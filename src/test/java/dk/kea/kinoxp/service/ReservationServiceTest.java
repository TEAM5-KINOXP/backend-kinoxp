package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.ReservationRequest;
import dk.kea.kinoxp.dto.ReservationResponse;
import dk.kea.kinoxp.entity.*;
import dk.kea.kinoxp.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
		void setUp()
			{
				reservationService=new ReservationService(userRepository,movieRepository,reservationRepository,movieShowRepository,seatRepository);
				Movie m1 = new Movie("Title1", "Description1", "Genre1", "TestIMG");
				Theater t1 = new Theater("Name1", 100);
				MovieShow s1 = new MovieShow(LocalDate.now(), m1, t1, 1);
				User u1=new User("username1","email1","password1","firstName1","lastName1");
				Reservation r1=new Reservation(s1,u1,1);
			}

//		@Test
//		void addReservationSuccess()
//			{
//				Movie m1 = new Movie("Title1", "Description1", "Genre1", "TestIMG");
//				Theater t1 = new Theater("Name1", 100);
//				MovieShow s1 = new MovieShow(LocalDate.now(), m1, t1, 1);
//				User u1=new User("username1","email1","password1","firstName1","lastName1");
////				Reservation r1=new Reservation(s1,u1,1);
//				Seat s2 = new Seat(1);
//
//				ReservationRequest reservationRequest = new ReservationRequest(1,1, "username1");
//				// Mock the behavior of repositories when findById is called
//				//Arrange
//				when(userRepository.findById(reservationRequest.getUserName())).thenReturn(Optional.of(u1)); // Mock user exists
//				when(movieShowRepository.findById(reservationRequest.getMovieShowId())).thenReturn(Optional.of(s1)); // Mock movieShow exists
//				when(seatRepository.findById(movieShowRepository.findById(reservationRequest.getMovieShowId()).get()
//						.getTheater().getSeats().get(reservationRequest.getSeatNumber()-1).getId())).thenReturn(Optional.of(s2)); // Mock seat exists
//			//	when(reservationRepository.save(any(Reservation.class))).thenReturn(r); // Mock reservation save
//				//Act
//				ReservationResponse response=reservationService.addReservation(reservationRequest);
//				//Assert
//				assertEquals(1,response.getMovieShow().getId());
//
//			//	assertEquals(1,response.getSeat().getId());
//				//assertEquals("username1",response.getUser().getUsername);
//
//			}
//@Test
//public void testAddReservation() {
//	// Create mock repositories
//	UserRepository userRepository = mock(UserRepository.class);
//	MovieShowRepository movieShowRepository = mock(MovieShowRepository.class);
//	SeatRepository seatRepository = mock(SeatRepository.class);
//	ReservationRepository reservationRepository = mock(ReservationRepository.class);
//	MovieRepository movieRepository = mock(MovieRepository.class);
//	TheaterRepository theaterRepository = mock(TheaterRepository.class);
//
//	// Create an instance of ReservationService with the mock repositories
//	ReservationService reservationService = new ReservationService(userRepository,movieRepository,reservationRepository,movieShowRepository,seatRepository);
//
//	// Create a sample ReservationRequest
//	ReservationRequest reservationRequest = new ReservationRequest(1, 1, "username");
//Seat s1 = new Seat(1);
//s1.setId(1);
//	// Mock the behavior of repositories when findById is called
//	when(userRepository.findById(anyString())).thenReturn(Optional.of(new User())); // Mock user exists
//	when(movieShowRepository.findById(anyInt())).thenReturn(Optional.of(new MovieShow())); // Mock movieShow exists
//	when(theaterRepository.findById(anyInt())).thenReturn(Optional.of(new Theater())); // Mock theater exists
//	when(seatRepository.findById(anyInt())).thenReturn(Optional.of(s1)); // Mock seat exists
//	when(reservationRepository.save(any(Reservation.class))).thenReturn(new Reservation()); // Mock reservation save
//
//	// Test the addReservation method
//	ReservationResponse reservationResponse = reservationService.addReservation(reservationRequest);
//
//	// Assert that the reservationResponse is not null and has the expected values
//	assertNotNull(reservationResponse);
//	assertEquals("username", reservationResponse.getUser().getUsername());
//	assertEquals(1, reservationResponse.getMovieShow().getId());
//	assertEquals(1, reservationResponse.getSeat().getSeatNumber());
//}
			@Test
			void addReservationFailUserNotFound()
				{

					ReservationRequest reservationRequest = new ReservationRequest(1,1, "nonExistentUser");

					// Mock the behavior of userRepository when findById is called for a non-existent user
					when(userRepository.findById(anyString())).thenReturn(Optional.empty());

					// Test the addReservation method with a non-existent user
					assertThrows(ResponseStatusException.class, () -> reservationService.addReservation(reservationRequest));
				}

		@Test
<<<<<<< HEAD
		void getAllReservations(){

		}
}
=======
		void getAllReservations()
			{
				Movie m1 = new Movie("Title1", "Description1", "Genre1", "TestIMG");
				Theater t1 = new Theater("Name1", 100);
				MovieShow s1 = new MovieShow(LocalDate.now(), m1, t1, 1);
				User u1=new User("username1","email1","password1","firstName1","lastName1");
				Reservation r1=new Reservation(s1,u1,1);

				//Arrange
				when(reservationRepository.findAll()).thenReturn(List.of(r1));
				//Act
				List<ReservationResponse> reservationResponse=reservationService.getAllReservations();
				//Assert
				assertEquals(1,reservationResponse.size());
			}

//		@Test
//		public void testAddReservation_UserNotFound() {
//			// Create mock repositories
//			UserRepository userRepository = mock(UserRepository.class);
//			MovieShowRepository movieShowRepository = mock(MovieShowRepository.class);
//			SeatRepository seatRepository = mock(SeatRepository.class);
//			ReservationRepository reservationRepository = mock(ReservationRepository.class);
//
//			// Create an instance of ReservationService with the mock repositories
//			ReservationService reservationService = new ReservationService(userRepository, movieShowRepository, seatRepository, reservationRepository);
//
//			// Create a sample ReservationRequest with a non-existent user
//			ReservationRequest reservationRequest = new ReservationRequest("nonExistentUser", "movieShowId", 1);
//
//			// Mock the behavior of userRepository when findById is called for a non-existent user
//			when(userRepository.findById(anyString())).thenReturn(Optional.empty());
//
//			// Test the addReservation method with a non-existent user
//			assertThrows(ResponseStatusException.class, () -> reservationService.addReservation(reservationRequest));
//		}

	}
>>>>>>> 4b89036de2b76506d101d4e50a80675d2f6236bc
