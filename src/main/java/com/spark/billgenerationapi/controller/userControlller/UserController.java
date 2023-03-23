package com.spark.billgenerationapi.controller.userControlller;

import com.spark.billgenerationapi.entity.User;
import com.spark.billgenerationapi.service.userService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
//@EnableMethodSecurity
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/")
    public void addUser(@RequestBody User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userServiceInterface.saveUser(user);
    }


    @GetMapping("/")
    public List<User> getAllUser()
    {
        return this.userServiceInterface.getAllUser();
    }

}
