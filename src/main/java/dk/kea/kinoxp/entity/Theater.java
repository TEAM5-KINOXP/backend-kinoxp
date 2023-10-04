package dk.kea.kinoxp.entity;

import dk.kea.kinoxp.repository.SeatRepository;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false, length = 50, unique = true)
    String name;

    int maxSeats;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seats = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;



public Theater(String name, int maxSeats) {
    this.name = name;
    this.maxSeats = maxSeats;
    this.seats = new ArrayList<>();
     for(int i = 0; i <= maxSeats-1; i++) {
         Seat seat=new Seat(i+1);
         seat.setTheater(this);
        this.seats.add(seat);
    }

     }

}
