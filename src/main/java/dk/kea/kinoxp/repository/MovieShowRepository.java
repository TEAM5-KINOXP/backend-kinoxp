package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
	@Override
	Optional<MovieShow> findById(Integer integer);

	List<MovieShow> findAllByMovieId(int id);
}
