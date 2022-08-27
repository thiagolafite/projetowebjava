package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable 
public class ScorePK implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne // Mapeando multiplicidade de relacionamento tb_score
	@JoinColumn(name="movie_id") // Mapeando join FK tabela tb_score
	private Movie movie;
	@ManyToOne 
	@JoinColumn(name="user_id")
	private User user;
	
	public ScorePK() {
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	}
