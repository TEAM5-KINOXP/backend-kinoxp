package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.entity.MovieShow;
import dk.kea.kinoxp.entity.Theater;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieShowRequest {
    private int id;
    private LocalDate showingDate;
    private int timeslot;
    int theaterId;
    String movieId;
    public MovieShowRequest(int id){
        this.id = id;
    }

    public MovieShowRequest(LocalDate showingDate, String movieId, int theaterId,  int timeslot) {
        this.showingDate = showingDate;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.timeslot = timeslot;
    }


}
