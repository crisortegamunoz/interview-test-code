package com.cristianortega.interview.codetest.web.controller;

import com.cristianortega.interview.codetest.domain.dto.UserDTO;
import com.cristianortega.interview.codetest.domain.service.UserDTOService;
import com.cristianortega.interview.codetest.persistence.entity.User;
import com.cristianortega.interview.codetest.service.UserService;
import com.cristianortega.interview.codetest.web.config.JwtUtil;
import com.cristianortega.interview.codetest.web.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserDTOService userDTOService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService,
                          UserDTOService userDTOService,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.userDTOService = userDTOService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody User user) {
        if (user.getId() == null && !this.userService.existsByEmail(user.getEmail())) {
            return this.userDTOService.save(user)
                    .map(aboutSaved -> new ResponseEntity<>(setToken(aboutSaved), HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    private UserDTO setToken(UserDTO userDTO) {
        userDTO.setToken(jwtUtil.create(userDTO.getEmail()));
        userDTO.setActive(true);
        return userDTO;
    }


}
