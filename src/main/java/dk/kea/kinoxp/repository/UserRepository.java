package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>
	{
		@Override
		Optional<User> findById(String s);
	}
