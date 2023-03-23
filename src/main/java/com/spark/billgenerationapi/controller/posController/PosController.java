package com.spark.billgenerationapi.controller.posController;


import com.spark.billgenerationapi.entity.Order;
import com.spark.billgenerationapi.service.BillGenerate.Generate;
import com.spark.billgenerationapi.service.BillGenerate.GenerateBill;
import com.spark.billgenerationapi.service.orderService.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pos")
public class PosController {

    @Autowired
    private OrderServiceInterface orderService;

    //here we save our order
    @PostMapping("/")
    public void saveOrder(@RequestBody Order order)
    {
        this.orderService.SaveOrder(order);
    }



    @Autowired
    private GenerateBill generateBill;
   //here we generate bill on orderId
    @GetMapping("/{orderId}")
    public Generate getGeneratedBill(@PathVariable("orderId") int orderId)
    {
        return this.generateBill.generateBill(orderId);
    }


}
