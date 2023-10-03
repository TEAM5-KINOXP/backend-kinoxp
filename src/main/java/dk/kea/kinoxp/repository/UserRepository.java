package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
	{

		User findByUsername(String user1);
	}
