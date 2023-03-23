package com.spark.billgenerationapi.service.userService;

import com.spark.billgenerationapi.entity.User;
import com.spark.billgenerationapi.repository.UserRepository;
import jakarta.annotation.security.DenyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
}
