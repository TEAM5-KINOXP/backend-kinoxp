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

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
    void test_createUser_Return_1_UserResponse(){
        User u1 = new User("username1", "email1",
                "password1", "firstName1", "lastName1");

        when(userRepository.save(any(User.class))).thenReturn(u1);
        
        UserRequest req = new UserRequest(u1);
        UserResponse res = userService.createUser(req);
        
        assertEquals("username1", res.getUsername());
    }
    @Test
    void testGetUsers(){
        User u1 = new User("username1", "email1",
                "password1", "firstName1", "lastName1");
        when(userRepository.findAll()).thenReturn(List.of(u1));

        List<UserResponse> res = userService.getUsers();
        assertEquals(1, res.size());
    }
    @Test
    void testGetUserByID(){
        User u1 = new User("username1", "email1",
                "password1", "firstName1", "lastName1");
        when(userRepository.findById("username1")).thenReturn(Optional.of(u1));
        UserResponse res = userService.getUserById("username1");
        assertEquals("username1", res.getUsername());
    }
    @Test
    void testUpdateUser(){
        UserRequest request = new UserRequest("username1", "NewEmail",
                "NewPassword", "NewFirstName", "NewLastName");
        User expectedUser = new User("username1", "email1",
                "password1", "firstName1", "lastName1");
        expectedUser.setFirstName("NewFirstName");
        expectedUser.setEmail("NewEmail");
        expectedUser.setLastName("NewLastName");
        expectedUser.setPassword("NewPassword");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);
        UserResponse response = userService.createUser(request);
        verify(userRepository).save(any(User.class));

        assertEquals(expectedUser.getFirstName(), response.getFirstName());
        assertEquals(expectedUser.getEmail(), response.getEmail());
        assertEquals(expectedUser.getLastName(), response.getLastName());
    }
    @Test
    void deleteUser(){
        User u1 = new User("username1", "email1",
                "password1", "firstName1", "lastName1");
        String testId = "username1";
        userService.deleteUser(testId);
        assertEquals(Optional.empty(), userRepository.findById("username1"));
    }
}