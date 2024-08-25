package com.arh.security_course.class1.repository;

import com.arh.security_course.class1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findUserByUsername(final String username);
}
