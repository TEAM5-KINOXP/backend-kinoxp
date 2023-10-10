package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dk.kea.kinoxp.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    
    public UserResponse(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
