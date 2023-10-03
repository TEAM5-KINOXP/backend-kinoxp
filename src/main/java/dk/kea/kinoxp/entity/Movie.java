package dk.kea.kinoxp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String genre;
    private String posterImg;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;

    @OneToMany(mappedBy = "movie")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;
    public void addReservation(Reservation reservation){
        if(reservations==null){
            reservations=List.of();
        }
        reservations.add(reservation);
    }
    public Movie(String title, String description, String genre, String posterImg) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.posterImg = posterImg;
    }
}
