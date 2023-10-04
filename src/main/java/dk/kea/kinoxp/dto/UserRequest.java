package dk.kea.kinoxp.dto;

import dk.kea.kinoxp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    String username;
    String email;
    String password;
    String firstName;
    String lastName;

    public UserRequest(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public static User getUserEntity(UserRequest userRequest){
        return new User(userRequest.getUsername(), userRequest.email, userRequest.password, userRequest.firstName, userRequest.lastName)
    }
}
