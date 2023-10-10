package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserUsername(String username);
}
