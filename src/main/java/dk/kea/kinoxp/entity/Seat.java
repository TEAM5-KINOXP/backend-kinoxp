package dk.kea.kinoxp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatNumber;
    //private boolean isReserved;

//    @ManyToMany
//    @JoinColumn(name = "seat_id")
//    MovieShow movieShow;
    @ManyToOne
    Theater theater;
    @OneToMany
    @JoinColumn(name = "seat_id")
    List<Reservation> reservations = new ArrayList<>();

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;

    }
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }


}
