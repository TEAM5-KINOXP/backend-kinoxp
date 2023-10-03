package dk.kea.kinoxp.service;

import dk.kea.kinoxp.repository.MovieRepository;
import dk.kea.kinoxp.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    TheaterRepository theaterRepository;
    MovieRepository movieRepository;

    public ScheduleService(TheaterRepository theaterRepository, MovieRepository movieRepository) {
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
    }
}
