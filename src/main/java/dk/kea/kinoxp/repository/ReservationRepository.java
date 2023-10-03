package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
