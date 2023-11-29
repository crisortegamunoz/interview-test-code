package com.cristianortega.interview.codetest.service;

import com.cristianortega.interview.codetest.persistence.entity.User;
import com.cristianortega.interview.codetest.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }

    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }
    public boolean existsByEmail(String email) {
        System.out.println(this.userRepository.existsByEmail(email));
        return this.userRepository.existsByEmail(email);
    }


}
