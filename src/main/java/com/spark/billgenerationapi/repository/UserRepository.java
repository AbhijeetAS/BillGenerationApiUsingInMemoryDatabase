package com.spark.billgenerationapi.repository;

import com.spark.billgenerationapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    public User findByUserId(String userId);
}
