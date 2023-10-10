package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.ReservationRequest;
import dk.kea.kinoxp.dto.ReservationResponse;
import dk.kea.kinoxp.entity.*;
import dk.kea.kinoxp.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.Arrays.stream;

@Service
public class ReservationService {
    UserRepository userRepository;
    MovieRepository movieRepository;
    ReservationRepository reservationRepository;
    MovieShowRepository movieShowRepository;
    SeatRepository SeatRepository;

    public ReservationService(UserRepository userRepository, MovieRepository movieRepository,
                              ReservationRepository reservationRepository,
                              MovieShowRepository movieShowRepository,SeatRepository SeatRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.reservationRepository = reservationRepository;
        this.movieShowRepository = movieShowRepository;
        this.SeatRepository = SeatRepository;
    }

    public ReservationResponse addReservation(ReservationRequest res)
        {
            // check if user exists
            User user = userRepository.findById(res.getUserName()).orElseThrow (
                  () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No member with this id found"));

            // check if movieShow exists
            MovieShow movieShow = movieShowRepository.findById(res.getMovieShowId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No movie-show with this id found"));
            //check if seat exists
            Seat seat = SeatRepository.findById(
                  movieShowRepository.findById(res.getMovieShowId()).get() // get movieShow
                        //through theaters list of seats get seat at index =seatnumber-1 and get seat id
                        .getTheater().getSeats().get(res.getSeatNumber()-1).getId())
                  .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No seat with this id found"));
            // check if seat is available: if seat is not reserved, then seat is available
            //seat is reserved if exists in reservations
                    if(movieShow.getReservations().stream().anyMatch(reservation -> reservation.getSeat().getId() == seat.getId())){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Seat is reserved");
                    }

            // add reservation
            Reservation reservation = new Reservation( movieShow,user, seat.getSeatNumber());
            reservationRepository.save(reservation);
            return new ReservationResponse(reservation);
        }

    public List<ReservationResponse> getAllReservations()
        {
            List<Reservation> reservations = reservationRepository.findAll();
            return reservations.stream().map(ReservationResponse::new).toList();
        }
}
