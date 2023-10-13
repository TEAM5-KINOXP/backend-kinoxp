package dk.kea.kinoxp.api;

import dk.kea.kinoxp.dto.MovieShowRequest;
import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.service.MovieShowService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("api/shows")
public class MovieShowController {
    MovieShowService movieShowService;

    public MovieShowController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    @GetMapping
    public List<MovieShowResponse> getAllMovieShows() {
        return movieShowService.getAllMovieShows();
    }


    @GetMapping(path = "/movie/{id}")
    public List<MovieShowResponse> getAllMovieShowsByMovieId(@PathVariable int id) {
        return movieShowService.getAllMovieShowsByMovieId(id);
    }
    @GetMapping("/admin")
    public List<MovieShowResponse> getAllMovieShowsAdmin () {
        return movieShowService.getAllMovieShowsAdmin();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieShowResponse createMovieShow (@RequestBody MovieShowRequest movieShowRequest){

    return movieShowService.createMovieShow(movieShowRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteMovieShow ( @PathVariable int id){
        movieShowService.deleteMovieShow(id);

    }
}
