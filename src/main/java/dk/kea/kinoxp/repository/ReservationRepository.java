package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	@Override
	Optional<Reservation> findById(Integer integer);
}
