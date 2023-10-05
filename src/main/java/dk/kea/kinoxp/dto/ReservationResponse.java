package dk.kea.kinoxp.dto;

import dk.kea.kinoxp.entity.MovieShow;
import dk.kea.kinoxp.entity.Reservation;
import dk.kea.kinoxp.entity.Seat;
import dk.kea.kinoxp.entity.User;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationResponse {
    int id;
    User user;
    Seat seat;
    MovieShow movieShow;
    LocalDate reservationDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.user = reservation.getUser();
        this.seat = reservation.getSeat();
        this.movieShow = reservation.getMovieShow();
        this.reservationDate = reservation.getReservationDate();
    }

}
