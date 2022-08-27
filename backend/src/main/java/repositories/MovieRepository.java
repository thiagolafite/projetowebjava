package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

