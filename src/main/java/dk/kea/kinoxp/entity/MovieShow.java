package dk.kea.kinoxp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate localDate;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;

    @ManyToOne
    Movie movie;
    @ManyToOne
    Theater theater;
    @OneToMany(mappedBy = "movieShow")
    List<Seat> seats;
    @OneToMany
    List<Reservation> reservations = new ArrayList<>();
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
    private int timeslot;
    public MovieShow(LocalDate localDate, Movie movie, Theater theater, int timeslot) {
        this.localDate = localDate;
        this.movie = movie;
        this.theater = theater;
        this.timeslot = timeslot;
    }
}
