package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.MovieShowRequest;
import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.entity.MovieShow;
import dk.kea.kinoxp.entity.Theater;
import dk.kea.kinoxp.repository.MovieRepository;
import dk.kea.kinoxp.repository.MovieShowRepository;
import dk.kea.kinoxp.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieShowService {
    TheaterRepository theaterRepository;
    MovieShowRepository movieShowRepository;
    MovieRepository movieRepository;




    public MovieShowService(TheaterRepository theaterRepository, MovieShowRepository movieShowRepository,
                            MovieRepository movieRepository) {
        this.theaterRepository = theaterRepository;
        this.movieShowRepository = movieShowRepository;
        this.movieRepository = movieRepository;
    }

    public List<MovieShowResponse> getAllMovieShows() {
        List<MovieShow> movieShows = movieShowRepository.findAll();
        return movieShows.stream().map(movieShow -> new MovieShowResponse(movieShow, false)).toList();
    }

    public MovieShowResponse createMovieShow(MovieShowRequest movieShowRequest) {

        Theater existingTheater = theaterRepository.findById(movieShowRequest.getTheaterId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Movie existingMovie = movieRepository.findByImdbID(movieShowRequest.getMovieId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        MovieShow newMovieShow = new MovieShow(
                movieShowRequest.getShowingDate(),
                existingMovie, existingTheater,
                movieShowRequest.getTimeslot());


        movieShowRepository.save(newMovieShow);
        return new MovieShowResponse(newMovieShow, false);
    }



}
