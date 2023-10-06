package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.UserRequest;
import dk.kea.kinoxp.dto.UserResponse;
import dk.kea.kinoxp.entity.User;
import dk.kea.kinoxp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;
    
    @Mock
    private UserRepository userRepository;
    
    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }
    
    @Test
    void Test_createUser_Return_1_UserResponse(){
        User u1 = new User("username1", "email1",
                "password1", "firstName1", "lastName1");

        when(userRepository.save(any(User.class))).thenReturn(u1);
        
        UserRequest req = new UserRequest(u1);
        UserResponse res = userService.createUser(req);
        
        assertEquals("username1", res.getUsername());


    }
}