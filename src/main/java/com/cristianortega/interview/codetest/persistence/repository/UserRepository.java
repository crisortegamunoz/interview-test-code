package com.cristianortega.interview.codetest.persistence.repository;

import com.cristianortega.interview.codetest.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

}
