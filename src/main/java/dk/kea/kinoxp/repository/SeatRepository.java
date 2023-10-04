package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer>
	{
	}
