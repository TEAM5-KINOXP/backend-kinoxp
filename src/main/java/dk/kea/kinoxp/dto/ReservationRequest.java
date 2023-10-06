package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dk.kea.kinoxp.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRequest
	{
		private int seatNumber;

		private int movieShowId;
		private String userName;

		public ReservationRequest(int seatNumber, int movieShowId, String userName){
			this.seatNumber = seatNumber;
			this.movieShowId = movieShowId;
			this.userName = userName;
		}

//		private static Reservation(ReservationRequest request){
//			return new Reservation(request.)
//					.seat(request.getSeatNumber())
//					.movieShowId(request.getMovieShowId())
//					.userName(request.getUserName())
//					.build();
		//}
	}
