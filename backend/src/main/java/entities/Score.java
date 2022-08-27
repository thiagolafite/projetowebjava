package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tb_score")
@Embeddable 
public class Score {
	@Column
	Double value;
	@EmbeddedId 
	private ScorePK id = new ScorePK();

	public Score() {
		// TODO Auto-generated constructor stub
	}
	public Score (Double value) {
		this.value = value;
		
	}
	
	
 


public double getValuee() {
		return value;
	}

	public void setValuee(Double valuee) {
		this.value = valuee;
	}


	public ScorePK getId() {
		return id;
	}


	public void setId(ScorePK id) {
		this.id = id;
	}


	public void setMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}


	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}


}
