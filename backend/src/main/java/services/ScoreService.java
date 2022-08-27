package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.MovieDTO;
import dto.ScoreDTO;
import entities.Movie;
import entities.Score;
import entities.User;
import repositories.MovieRepository;
import repositories.ScoreRepository;
import repositories.UserRepository;

@Service
public class ScoreService {
	@Autowired
	private MovieRepository movieRepository; // Composição de componentes.
	@Autowired
	private UserRepository userRepository; // Composição de componentes.
	@Autowired
	private ScoreRepository scoreRepository; // Composição de componentes
	
	@Transactional(readOnly = false)
	public MovieDTO saveScore(ScoreDTO scoreDTO){
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if ( user == null ) {
			user = new User();
			//System.out.println(scoreDTO.getEmail());	
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		if (movie != null) {
			Score score = new Score();
			score.setMovie(movie);
			score.setUser(user);
			score.setValuee(scoreDTO.getScore());
			score = scoreRepository.saveAndFlush(score); // Salva e atualiza os resultados
		}

		double soma = 0.0;
		for ( Score s : movie.getScores() ) {
			soma = soma + s.getValuee();
		}
		
		double avgScore = soma / movie.getScores().size();
		
		movie.setScore(avgScore);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
	MovieDTO movieDTO = new MovieDTO(movie);
		
		return movieDTO;
	}


}
