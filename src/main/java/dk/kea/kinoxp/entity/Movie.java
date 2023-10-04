package dk.kea.kinoxp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<MovieShow> movieShows;

    public Movie(String title, String description, String genre, String posterImg) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.posterImg = posterImg;
    }
}
