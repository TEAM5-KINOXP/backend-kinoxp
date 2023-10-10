package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.ReservationResponse;
import dk.kea.kinoxp.entity.Reservation;
import dk.kea.kinoxp.entity.User;
import dk.kea.kinoxp.repository.MovieShowRepository;
import dk.kea.kinoxp.repository.UserRepository;
import dk.kea.kinoxp.repository.ReservationRepository;
import dk.kea.kinoxp.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {
    UserRepository userRepository;
    MovieRepository movieRepository;
    ReservationRepository reservationRepository;
    MovieShowRepository movieShowRepository;

    public ReservationService(UserRepository userRepository, MovieRepository movieRepository,
                              ReservationRepository reservationRepository, MovieShowRepository movieShowRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.reservationRepository = reservationRepository;
        this.movieShowRepository = movieShowRepository;
    }

    public List<ReservationResponse> getReservationsForUser(String username) {
        User user = userRepository.findById(username).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        List<Reservation> reservations = reservationRepository.findByUserUsername(username);
        List<ReservationResponse> response = reservations.stream().map(res ->
                new ReservationResponse(res)).toList();
        return response;
    }

    public void deleteReservation(int res_id) {
        reservationRepository.deleteById(res_id);
    }
}
