package dk.kea.kinoxp.entity;


import dk.kea.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class User extends UserWithRoles {
	@NonNull
	@Column(nullable = false,length = 50)
	private String firstName;
	@NonNull
	@Column(nullable = false,length = 50)
	private String lastName;
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime edited;

	// addrelations
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;

	public User(String username, String email, String password, String firstName, String lastName) {
		super(username, email, password);
		this.firstName = firstName;
		this.lastName = lastName;

	}
	public void addReservation(Reservation reservation){
		if(reservations==null){
			reservations=new ArrayList<>();
		}
		reservations.add(reservation);
	}
}

