package dk.kea.kinoxp.config;

import dk.kea.kinoxp.entity.*;
import dk.kea.kinoxp.repository.*;
import dk.kea.security.entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Base64;

@Configuration

public class DeveloperData implements ApplicationRunner
	{
		MovieRepository movieRepository;
		ReservationRepository reservationRepository;
		TheaterRepository theaterRepository;
		UserRepository userRepository;
		MovieShowRepository movieShowRepository;
		SeatRepository seatRepository;

		public DeveloperData(MovieRepository movieRepository, ReservationRepository reservationRepository,
									TheaterRepository theaterRepository, UserRepository userRepository,
									MovieShowRepository movieShowRepository, SeatRepository seatRepository)
			{
				this.movieRepository = movieRepository;
				this.reservationRepository = reservationRepository;
				this.theaterRepository = theaterRepository;
				this.userRepository = userRepository;
				this.movieShowRepository = movieShowRepository;
				this.seatRepository = seatRepository;
			}

		@Override
		public void run(ApplicationArguments args) throws Exception {
			String imagePath = "static/tempimg.png";
			ClassPathResource resource = new ClassPathResource(imagePath);

			InputStream inputStream = resource.getInputStream();
			byte[] fileContent = StreamUtils.copyToByteArray(inputStream);
			String encodedString = new String(Base64.getEncoder().encode(fileContent), StandardCharsets.UTF_8);
			System.out.println(encodedString);

			LocalDate date = LocalDate.now();
			LocalDate date2 = date.plusDays(5);
			//Users
			User admin1 = new User("admin1", "admin@admin.com", "password1", "adminFirstname", "adminLastName");
			admin1.addRole(Role.ADMIN);
			userRepository.save(admin1);
			
			
			User u1 = new User("username1", "email1", "password1", "firstName1", "lastName1");
			u1.addRole(Role.USER);
			userRepository.save(u1);
			User u2 = new User("username2", "email2", "password2", "firstName1", "lastName1");
			u2.addRole(Role.ADMIN);
			userRepository.save(u2);
			//movies:
			Movie m1 = new Movie("Title1", "Description1", "Genre1", encodedString);
			movieRepository.save(m1);
			Movie m2 = new Movie("Title2", "Description2", "Genre2", encodedString);
			movieRepository.save(m2);
			Movie m3 = new Movie("Title3", "Description3", "Genre3", encodedString);
			movieRepository.save(m3);

			//Theaters
			Theater t1 = new Theater("Name1", 240); // theater creates seats
			theaterRepository.save(t1);
			seatRepository.saveAll(t1.getSeats());
			Theater t2 = new Theater("Name2", 400); // theater creates seats
			theaterRepository.save(t2);
			seatRepository.saveAll(t2.getSeats());


			//Shows
			MovieShow s1 = new MovieShow(date, m1, t1, 1);
			movieShowRepository.save(s1);
			MovieShow s2 = new MovieShow(date, m2, t2, 2);
			MovieShow s3 = new MovieShow(date2, m2, t1, 2);
			movieShowRepository.save(s2);
			movieShowRepository.save(s3);

			MovieShow s4 = new MovieShow(date, m3, t1, 1);
			movieShowRepository.save(s4);

			//Reservations : something fails here

			Reservation r1 = new Reservation(s1, u1, 1);
			Reservation r2 = new Reservation(s2, u1, 69);
			Reservation r3 = new Reservation(s3, u1, 69);
			reservationRepository.save(r1);
			reservationRepository.save(r2);
			reservationRepository.save(r3);

		}
	}

