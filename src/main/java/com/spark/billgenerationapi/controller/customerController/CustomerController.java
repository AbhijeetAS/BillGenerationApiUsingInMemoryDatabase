package com.spark.billgenerationapi.controller.customerController;


import com.spark.billgenerationapi.entity.Order;
import com.spark.billgenerationapi.service.orderService.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderServiceInterface orderService;

    //check the previous order of same person

    @GetMapping("/{customerId}")
    public List<Order> orderHistory(@PathVariable String customerId)
    {
        return this.orderService.orderHistory(customerId);
    }
}
