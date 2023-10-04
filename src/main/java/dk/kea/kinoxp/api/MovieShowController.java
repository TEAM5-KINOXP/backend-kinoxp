package dk.kea.kinoxp.api;

import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.service.MovieShowService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
