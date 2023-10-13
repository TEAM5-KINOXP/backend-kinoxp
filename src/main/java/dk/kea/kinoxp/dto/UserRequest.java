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

    public UserRequest(User u1) {
        this.username = u1.getUsername();
        this.email = u1.getEmail();
        this.password = u1.getPassword();
        this.firstName = u1.getFirstName();
        this.lastName = u1.getLastName();
    
    }

    public static User getUserEntity(UserRequest userRequest){
        return new User(userRequest.username,
                        userRequest.email,
                        userRequest.password,
                        userRequest.firstName,
                        userRequest.lastName);
    }
}
