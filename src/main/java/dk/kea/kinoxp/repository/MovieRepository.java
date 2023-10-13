package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByImdbID(String imdbId);
}
