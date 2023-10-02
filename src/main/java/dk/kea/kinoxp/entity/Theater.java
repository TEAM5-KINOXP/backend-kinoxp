package dk.kea.kinoxp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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

    @Column(nullable = false, length = 50, unique = true)
    int seat;

}
