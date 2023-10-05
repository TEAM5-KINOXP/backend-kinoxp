package dk.kea.kinoxp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/movies")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/imdbid/{imdbId}")
    public Movie getMovie(@PathVariable String imdbId) {
        return movieService.getMovieByImdbId(imdbId);
    }
    @PostMapping("/{imdbId}")
    public Movie addMovie(@PathVariable String imdbId) throws JsonProcessingException {
        return movieService.addMovie(imdbId);
    }

}
