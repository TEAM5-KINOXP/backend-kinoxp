package dk.kea.kinoxp.api;

import dk.kea.kinoxp.service.MovieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/movies")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
