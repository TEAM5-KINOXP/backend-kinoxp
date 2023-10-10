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
    private int id;
    private LocalDate reservationDate;
    private String movieTitle;
    private int movieShowId;
    private int seatId;
    private int timeslot;

    public ReservationResponse(Reservation reservation){
        this.id = reservation.getId();
        this.reservationDate = reservation.getReservationDate();
        if(reservation.getMovieShow() != null) {
            this.movieShowId = reservation.getMovieShow().getId();
            this.movieTitle = reservation.getMovieShow().getMovie().getTitle();
            this.seatId = reservation.getSeat().getId();
            this.timeslot = reservation.getMovieShow().getTimeslot();
        }
    }
}
