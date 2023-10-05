package dk.kea.kinoxp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate reservationDate; //not necessesary - MovieShow holds the date
    @ManyToOne
    User user;
    @ManyToOne
    MovieShow movieShow;
    @ManyToOne

    Seat seat;
    public Reservation(MovieShow movieShow, User user, int seatNumber) {
        this.reservationDate = movieShow.getShowingDate();
        this.movieShow = movieShow;
        this.user = user;
        user.addReservation(this);
        this.seat=getSeat(seatNumber,movieShow);
       // seat.addReservation(this);
        movieShow.addReservation(this);

    }
    private static Seat getSeat(int seatNumber, MovieShow movieShow) {
        return movieShow.getTheater().getSeats().get(seatNumber-1);
    }
}
