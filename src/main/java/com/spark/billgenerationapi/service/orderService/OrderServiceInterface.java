package com.spark.billgenerationapi.service.orderService;

import com.spark.billgenerationapi.entity.Order;

import java.text.ParseException;
import java.util.List;

public interface OrderServiceInterface {
        public void SaveOrder(Order order);

        public List<Order> orderHistory(String customerId);

        public List<Order> findOrderInOneDay(String date) throws ParseException;

        public Float totalEarningInOneDay(String date) throws ParseException;

        public Float dailyEarningAtOnePos(String posId);


    }

