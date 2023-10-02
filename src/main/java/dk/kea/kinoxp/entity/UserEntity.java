package dk.kea.kinoxp.entity;


import dk.kea.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class UserEntity extends UserWithRoles {
	@NonNull
	@Column(nullable = false,length = 50)
	private String firstName;
	@NonNull
	@Column(nullable = false,length = 50)
	private String lastName;

	// addrelations
	private List<Reservation> reservations;

}
public UserEntity(String username, String email, String password, String firstName, String lastName, List<Reservation> reservations) {
	super(username, email, password);
	this.username = username;
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.reservations = reservations;
}
	public void addReservation(Reservation reservation){
		if(reservations==null){
			reservations=new ArrayList<>();
		}
		reservations.add(reservation);
	}
