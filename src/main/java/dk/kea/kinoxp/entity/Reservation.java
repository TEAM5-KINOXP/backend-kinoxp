package dk.kea.kinoxp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate reservationDate;
    @ManyToOne
    User user;
    @ManyToOne
    Movie movie;
    public Reservation(LocalDate rentalDate, Movie movie, User user) {
        this.reservationDate = rentalDate;
        this.movie = movie;
        this.user = user;
        movie.addReservation(this);
        user.addReservation(this);
    }
}
