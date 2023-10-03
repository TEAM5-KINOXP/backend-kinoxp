package dk.kea.kinoxp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatNumber;
    private boolean isReserved;

    public Seat(int seatNumber, boolean isReserved) {
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }


}
