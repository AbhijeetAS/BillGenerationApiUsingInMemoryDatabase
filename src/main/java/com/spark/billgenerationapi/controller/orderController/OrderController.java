package com.spark.billgenerationapi.controller.orderController;

import com.spark.billgenerationapi.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spark.billgenerationapi.service.orderService.OrderServiceInterface;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderServiceInterface orderService;

    //get the order of the same date
    @GetMapping("/{date}")
    public List<Order> getOrderByDate(@PathVariable ("date") String date) throws ParseException {
        return this.orderService.findOrderInOneDay(date);
    }

    //total earning in one day
    @GetMapping("/date/{date}")
    public Float getTotalEarningInOneDay(@PathVariable String date) throws ParseException {
        return this.orderService.totalEarningInOneDay(date);
    }


    //total earnig in one day at one pos
    @GetMapping("/posId/{posId}")
    public Float getTotalEarningAtOnePos(@PathVariable String posId)
    {
        return this.orderService.dailyEarningAtOnePos(posId);
    }





}
