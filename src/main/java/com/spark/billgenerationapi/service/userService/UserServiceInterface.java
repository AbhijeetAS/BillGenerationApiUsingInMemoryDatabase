package com.spark.billgenerationapi.service.userService;

import com.spark.billgenerationapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {

    public void saveUser(User user);
    public List<User> getAllUser();
}
