package dk.kea.kinoxp.service;

import dk.kea.kinoxp.repository.UserRepository;
import dk.kea.kinoxp.repository.ReservationRepository;
import dk.kea.kinoxp.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    UserRepository userRepository;
    MovieRepository movieRepository;
    ReservationRepository reservationRepository;

    public ReservationService(UserRepository userRepository, MovieRepository movieRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.reservationRepository = reservationRepository;
    }
}
