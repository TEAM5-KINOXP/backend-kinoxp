package dk.kea.kinoxp.service;

import dk.kea.kinoxp.repository.MovieRepository;
import dk.kea.kinoxp.repository.ReservationRepository;

public class TheaterService {
    ReservationRepository reservationRepository;
    ScheduleRepository scheduleRepository;

    public TheaterService(ReservationRepository reservationRepository, ScheduleRepository scheduleRepository) {
        this.reservationRepository = reservationRepository;
        this.scheduleRepository = scheduleRepository;
    }
}
