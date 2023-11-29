package com.cristianortega.interview.codetest.web.config;

import com.cristianortega.interview.codetest.persistence.entity.Phone;
import com.cristianortega.interview.codetest.persistence.entity.User;
import com.cristianortega.interview.codetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class LoadDataRunner implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public LoadDataRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        User user = new User();
        user.setName("Cristian Ortega");
        user.setEmail("soy@cristianortega.com");
        user.setPassword("Kea8VJITeQL4tTW");
        Phone phone = new Phone();
        phone.setNumber("996436811");
        phone.setCityCode("9");
        phone.setCountryCode("56");
        user.setPhones(Collections.singletonList(phone));
        userService.save(user);
    }
}
