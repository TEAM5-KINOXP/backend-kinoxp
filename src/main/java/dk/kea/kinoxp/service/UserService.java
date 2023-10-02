package dk.kea.kinoxp.service;

import dk.kea.kinoxp.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class UserService
	{
		UserRepository userRepository;
	}
	public List<UserResponse> getAllUsers()
		{
			List<UserEntity> users=UserRepository.findAll();
			List<UserResponse> respons=users.stream().map((user -> new UserResponse(user))).toList();
			return respons;
		}
		public UserResponse getUserById(String username){
			UserEntity user= getUser(username);
			return new UserResponse(user);
		}
public ResponseEntity<Boolean> updateUser(String username, UserRequest userRequest){
	UserEntity user= getUser(username);
	if(!userRequest.getUserName().equals(username)){
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change username");
		}
	user.setEmail(userRequest.getEmail());
	user.setPassword(userRequest.getPassword());
	user.setFirstName(userRequest.getFirstName());
	user.setLastName(userRequest.getLastName());
	userRepository.save(user);
	return ResponseEntity.ok(true);
}
public UserResponse createUser(UserRequest userRequest){
	UserEntity user=UserRequest.getUserEntity(userRequest);
	userRepository.save(user);
	return new UserResponse(user);
}
public UserEntity getUser(String username){
	return userRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
}
public void deleteUser(String username){
	userRepository.deleteById(username);
}