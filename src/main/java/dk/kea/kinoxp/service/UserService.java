package dk.kea.kinoxp.service;

import dk.kea.kinoxp.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
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
