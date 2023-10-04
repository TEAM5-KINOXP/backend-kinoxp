package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.entity.MovieShow;
import dk.kea.kinoxp.repository.MovieShowRepository;
import dk.kea.kinoxp.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowService {
    TheaterRepository theaterRepository;
    MovieShowRepository movieShowRepository;

    public MovieShowService(TheaterRepository theaterRepository, MovieShowRepository movieShowRepository) {
        this.theaterRepository = theaterRepository;
        this.movieShowRepository = movieShowRepository;
    }

    public List<MovieShowResponse> getAllMovieShows() {
        List<MovieShow> movieShows = movieShowRepository.findAll();
        return movieShows.stream().map(movieShow -> new MovieShowResponse(movieShow)).toList();
    }
}
