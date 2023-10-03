package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
}
