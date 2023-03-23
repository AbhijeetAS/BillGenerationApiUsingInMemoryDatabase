package com.spark.billgenerationapi.entity;

import com.spark.billgenerationapi.dto.Roles;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    private String userId;
    private String password;
    private Roles role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
       this.role = role;
    }

    public User(String userId, String password, Roles role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }
}
