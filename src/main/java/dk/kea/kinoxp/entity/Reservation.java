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
    MovieShow movieShow;
    public Reservation(LocalDate rentalDate, MovieShow movieShow, User user) {
        this.reservationDate = rentalDate;
        this.movieShow = movieShow;
        this.user = user;
        movieShow.addReservation(this);
        user.addReservation(this);
    }
}
