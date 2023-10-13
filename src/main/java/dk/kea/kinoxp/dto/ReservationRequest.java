package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRequest
	{
		private int seatNumber;

		private int movieShowId;
		private String username;

		public ReservationRequest(int seatNumber, int movieShowId, String username){
			this.seatNumber = seatNumber;
			this.movieShowId = movieShowId;
			this.username = username;
		}

//		private static Reservation(ReservationRequest request){
//			return new Reservation(request.)
//					.seat(request.getSeatNumber())
//					.movieShowId(request.getMovieShowId())
//					.userName(request.getUserName())
//					.build();
		//}
	}
