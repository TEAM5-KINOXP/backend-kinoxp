package dk.kea.kinoxp.api;

import dk.kea.kinoxp.dto.UserRequest;
import dk.kea.kinoxp.dto.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import dk.kea.kinoxp.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("api/users")

public class UserController {
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//ADMIN refers to T5K-37
//	@PreAuthorize("hasAuthority('ADMIN')") prepared for security
	@GetMapping("")
	public List<UserResponse> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/users-for-authenticated")
	public UserResponse getUserBy_Id(Principal principal) throws Exception {
		return userService.getUserById(principal.getName());
	}

	@PutMapping(path = "/users-for-authenticated")
	public ResponseEntity<Boolean> updateUser(Principal	principal, @RequestBody UserRequest userRequest) {
		return userService.updateUser(principal.getName(), userRequest);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return userService.createUser(userRequest);
	}

	@DeleteMapping(path = "/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}
}