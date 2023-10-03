package dk.kea.kinoxp.api;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import dk.kea.kinoxp.service.UserService;
@RestController
@CrossOrigin
@RequestMapping("api/users")

public class UserController {
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	//ADMIN refers to T5K-37
//	@PreAuthorize("hasAuthority('ADMIN')") prepared for security
	@GetMapping("/admin")
	public List<UserResponse> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/{username}")
	public UserResponse getUserById(@PathVariable String username) throws Exception {
		return userService.findById(username);
	}

	@PutMapping(path = "/{username}")
	public UserResponse updateUser(@PathVariable String username, @RequestBody UserRequest userRequest) {
		return userService.updateUser(username, userRequest);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return userService.createUser(userRequest);
	}

	@DeleteMapping(path = "/{username}")
	void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}
}