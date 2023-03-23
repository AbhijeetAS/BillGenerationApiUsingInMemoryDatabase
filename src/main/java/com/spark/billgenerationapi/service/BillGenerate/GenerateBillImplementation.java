package com.spark.billgenerationapi.service.BillGenerate;

import com.spark.billgenerationapi.entity.Order;
import com.spark.billgenerationapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateBillImplementation implements GenerateBill {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Generate generateBill(int orderID) {
        Order order=this.orderRepository.findByOrderId(orderID);
        return new Generate(order.getCustomerId(),order.getItems());
    }




}
