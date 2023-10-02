package dk.kea.kinoxp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate rentalDate;

    public Reservation(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
}
