package dk.kea.kinoxp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 2000)
    private String description;
    private String genre;
    @Column(length = 1000000)
    private String posterImg;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;

    @Column(unique = true)
    private String imdbID;
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
