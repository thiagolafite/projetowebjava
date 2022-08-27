package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.MovieDTO;
import dto.ScoreDTO;
import services.ScoreService;

@RestController
@RequestMapping(value = "/scores")

public class ScoreController {
	@Autowired
	private ScoreService service; // Composição de componentes, injeção de dependência.
	
	@PutMapping // Idempotente,  requisição idêntica, sempre vai gravar o mesmo dado, de acordo com os parâmetros.
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
		MovieDTO movieDTO = service.saveScore(scoreDTO);
		return movieDTO; 	}
}


