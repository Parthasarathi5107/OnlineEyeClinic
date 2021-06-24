package com.g6.onlineeyecare.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g6.onlineeyecare.user.dto.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	@Query("Select a from User a where a.userName=:name")
	Optional<User> findByuserName(@Param("name") String name);
}
