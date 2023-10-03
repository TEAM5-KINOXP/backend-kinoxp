package dk.kea.kinoxp.config;

import dk.kea.kinoxp.entity.*;
import dk.kea.kinoxp.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration

public class DeveloperData implements ApplicationRunner
	{
		MovieRepository movieRepository;
		ReservationRepository reservationRepository;
		TheaterRepository theaterRepository;
		UserRepository userRepository;
		MovieShowRepository movieShowRepository;

		public DeveloperData(MovieRepository movieRepository, ReservationRepository reservationRepository,
									TheaterRepository theaterRepository, UserRepository userRepository, MovieShowRepository movieShowRepository)
			{
				this.movieRepository = movieRepository;
				this.reservationRepository = reservationRepository;
				this.theaterRepository = theaterRepository;
				this.userRepository = userRepository;
				this.movieShowRepository = movieShowRepository;
			}

		@Override
		public void run(ApplicationArguments args) throws Exception{
			//Users
			User u1=new User("username1","email1","password1","firstName1","lastName1");
			userRepository.save(u1);

			//movies:
			Movie m1=new Movie("Title1","Description1","Genre1","PosterImg1");
			movieRepository.save(m1);

			//Theaters
			Theater t1=new Theater("Name1",100);
			theaterRepository.save(t1);


			//Shows
			MovieShow s1=new MovieShow(LocalDate.now(),m1,t1,1);
			movieShowRepository.save(s1);

			//Reservations
			Reservation r1=new Reservation(LocalDate.now(),s1,u1);
			reservationRepository.save(r1);

		}
	}

