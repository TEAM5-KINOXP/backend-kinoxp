package dk.kea.kinoxp.config;

import dk.kea.kinoxp.repository.MovieRepository;
import dk.kea.kinoxp.repository.ReservationRepository;
import dk.kea.kinoxp.repository.TheaterRepository;
import dk.kea.kinoxp.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DeveloperData
	{
		MovieRepository movieRepository;
		ReservationRepository reservationRepository;
		TheaterRepository theaterRepository;
		UserRepository userRepository;

		public DeveloperData(MovieRepository movieRepository, ReservationRepository reservationRepository,
									TheaterRepository theaterRepository, UserRepository userRepository)
			{
				this.movieRepository = movieRepository;
				this.reservationRepository = reservationRepository;
				this.theaterRepository = theaterRepository;
				this.userRepository = userRepository;
			}

		@Override
		public void run(ApplicationArguments args) throws Exception{
			// TODO Auto-generated method stub
		}
	}

