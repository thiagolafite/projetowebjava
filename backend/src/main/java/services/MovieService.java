package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import dto.MovieDTO;
import entities.Movie;
import repositories.MovieRepository;


@Service 
public class MovieService {
	@Autowired
	private MovieRepository repository;
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page; 	
		 }
	@Transactional(readOnly = true)
	public MovieDTO findBYId(Long id){
		Movie result = repository.findById(id).get();
		MovieDTO movieDTO = new MovieDTO(result);
		return movieDTO;
	}

}