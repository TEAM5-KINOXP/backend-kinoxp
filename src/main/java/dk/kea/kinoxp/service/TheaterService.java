package dk.kea.kinoxp.service;

import dk.kea.kinoxp.repository.ReservationRepository;
import dk.kea.kinoxp.repository.MovieShowRepository;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    ReservationRepository reservationRepository;
    MovieShowRepository scheduleRepository;

    public TheaterService(ReservationRepository reservationRepository, MovieShowRepository movieShowRepository) {
        this.reservationRepository = reservationRepository;
        this.scheduleRepository = scheduleRepository;
    }
}
