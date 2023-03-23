package com.spark.billgenerationapi.repository;

import com.spark.billgenerationapi.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
    public Order findByOrderId(int orderId);
    public List<Order> findAllByCustomerId(String customerId);

    public List<Order>findAllByDateBetween(Date start, Date end);

    public List<Order> findAllByPosId(String posId);

}
