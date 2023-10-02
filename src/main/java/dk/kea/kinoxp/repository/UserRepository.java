package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String>
	{

	}
