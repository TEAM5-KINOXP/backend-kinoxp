package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer>
	{
		@Override
		Optional<Seat> findById(Integer integer);
	}
