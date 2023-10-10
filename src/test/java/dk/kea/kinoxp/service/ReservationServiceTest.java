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
class ReservationServiceTest
	{
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
		void setUp()
			{
				reservationService=new ReservationService(userRepository,movieShowRepository,reservationRepository,seatRepository);
				Movie m1 = new Movie("Title1", "Description1", "Genre1", "TestIMG");
				Theater t1 = new Theater("Name1", 100);
				MovieShow s1 = new MovieShow(LocalDate.now(), m1, t1, 1);
				User u1=new User("username1","email1","password1","firstName1","lastName1");
				Reservation r1=new Reservation(s1,u1,1);
			}

		@Test
		void addReservation()
			{

			}

		@Test
		void getAllReservations()
			{
			}
	}