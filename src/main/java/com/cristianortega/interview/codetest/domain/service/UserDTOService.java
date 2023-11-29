package com.cristianortega.interview.codetest.domain.service;

import com.cristianortega.interview.codetest.domain.dto.UserDTO;
import com.cristianortega.interview.codetest.persistence.entity.User;
import com.cristianortega.interview.codetest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDTOService {

    private final UserService userService;

    public UserDTOService(UserService userService) {
        this.userService = userService;
    }

    public Optional<UserDTO> save(User user) {
        UserDTO userDTO = new UserDTO();
        this.userService.save(user).ifPresent(userDB -> {
            userDTO.setId(userDB.getId());
            userDTO.setName(userDB.getName());
            userDTO.setEmail(userDB.getEmail());
            userDTO.setPassword(userDB.getPassword());
            userDTO.setPhones(userDB.getPhones());
            userDTO.setCreated(userDB.getCreated());
            userDTO.setModified(userDB.getModified());
            userDTO.setLastLogin(userDB.getModified());
        });
        return Optional.of(userDTO);
    }

}
