package dk.kea.kinoxp.api;

import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.service.MovieShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/shows")
public class MovieShowController {
    MovieShowService movieShowService;

    public MovieShowController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }
    @GetMapping
    public List<MovieShowResponse> getAllMovieShows(){
        return movieShowService.getAllMovieShows();
    }

    @GetMapping(path="/movie/{id}")
    public List<MovieShowResponse> getAllMovieShowsByMovieId(@PathVariable int id){
        return movieShowService.getAllMovieShowsByMovieId(id);
    }
}
