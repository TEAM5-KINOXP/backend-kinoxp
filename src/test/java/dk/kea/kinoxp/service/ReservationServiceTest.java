package dk.kea.kinoxp.service;

import dk.kea.kinoxp.entity.*;
import dk.kea.kinoxp.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReservationServiceTest{
private ReservationService reservationService;
@Mock
private ReservationRepository reservationRepository;
@Mock
private MovieShowRepository movieShowRepository;
@Mock
private SeatRepository seatRepository;
@Mock
private UserRepository userRepository;
@Mock
private TheaterRepository theaterRepository;
@Mock
private MovieRepository movieRepository;
		@BeforeEach
		void setUp(){

		}

		@Test
		void addReservation(){

		}

		@Test
		void getAllReservations(){

		}
}