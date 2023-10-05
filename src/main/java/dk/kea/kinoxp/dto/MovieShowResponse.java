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
@AllArgsConstructor //A must for builder
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieShowResponse {
    private int id;
    private LocalDate showingDate;
    private int timeslot;
    List<ReservationResponse> reservations;
    Theater theater;
    Movie movie;

    public MovieShowResponse(MovieShow movieShow, boolean showRes) {
        this.id = movieShow.getId();
        this.showingDate = movieShow.getShowingDate();
        this.timeslot = movieShow.getTimeslot();
        if(movieShow.getTheater() != null){
            this.theater = movieShow.getTheater();
        }
        if(movieShow.getMovie() != null){
            this.movie = movieShow.getMovie();
        }
        if(movieShow.getReservations() != null && showRes){
            reservations = movieShow.getReservations().stream().map((res) -> new ReservationResponse()).toList();
        }
    }
}
