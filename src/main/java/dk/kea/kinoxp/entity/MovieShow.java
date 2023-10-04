package dk.kea.kinoxp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
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
    private int timeslot;
    private LocalDate showingDate;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;

    @ManyToOne
    Movie movie;
    @ManyToOne
    Theater theater;

    //available seats we could remove a seat from the list if it was reserved. or we could
    //change to Map<Seat,Boolean> and switch the Boolean to false if the seat was reserved

    @ManyToMany
    List<Seat> seats;
    @OneToMany(mappedBy = "movieShow")
    List<Reservation> reservations = new ArrayList<>();

    public MovieShow(LocalDate showingDate, Movie movie, Theater theater, int timeslot) {
        this.showingDate = showingDate;
        this.movie = movie;
        this.theater = theater;
        this.timeslot = timeslot;
        this.seats = new ArrayList<>();
        for(int i = 0; i <= theater.getSeats().size()-1; i++) {
          Seat  seat=theater.getSeats().get(i);
            this.seats.add(seat);
        }


    }
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

}
