package dk.kea.kinoxp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
     for(int i = 1; i <= maxSeats; i++) {
        this.seats.add(new Seat(i, false));
    }
     }

}
