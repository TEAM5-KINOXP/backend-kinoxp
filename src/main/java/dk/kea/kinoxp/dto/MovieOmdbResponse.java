package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovieOmdbResponse {


    @JsonProperty("Title")
    private String title;

    @JsonProperty("Plot")
    private String description;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Poster")
    private String posterImg;
    @JsonProperty("imdbID")
    private String imdbID;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;



}
