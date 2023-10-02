package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
