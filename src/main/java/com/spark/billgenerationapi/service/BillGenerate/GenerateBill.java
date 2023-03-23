package com.spark.billgenerationapi.service.BillGenerate;

import com.spark.billgenerationapi.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenerateBill {

    public Generate generateBill(int orderID);


}
