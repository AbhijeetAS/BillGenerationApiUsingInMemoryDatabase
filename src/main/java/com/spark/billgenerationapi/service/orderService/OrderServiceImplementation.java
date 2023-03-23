package com.spark.billgenerationapi.service.orderService;
import com.spark.billgenerationapi.dto.Item;
import com.spark.billgenerationapi.entity.Order;
import com.spark.billgenerationapi.repository.OrderRepository;
import com.spark.billgenerationapi.service.orderService.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImplementation implements OrderServiceInterface {
    @Autowired
    private OrderRepository orderRepository;



    @Override
    public void SaveOrder(Order order) {
        //for getting the total cost
        Float totalCost=null;
        List<Item> cost=order.getItems();
        List<String>costList=cost.stream().map(element->element.getPrice()).collect(Collectors.toList());
        List<Float> updateList = costList.stream().map(element -> Float.parseFloat(element)).collect(Collectors.toList());
        Float newTotalCost=updateList.stream().reduce(0.f,(a,b)->a+b);
        order.setTotalCost(newTotalCost);

        //for setting the date in the database by String approch
//        String pattern = "MM-dd-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        order.setDate(date);

        Date date=new Date();
        order.setDate(date);

        this.orderRepository.save(order);
    }


    @Override
    public List<Order> orderHistory(String customerId) {

        List<Order> list=this.orderRepository.findAllByCustomerId(customerId);
        return list;

    }

    @Override
    public List<Order> findOrderInOneDay(String date) throws ParseException {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dayStart=simpleDateFormat.parse(date);
        Date dayEnd=simpleDateFormat.parse(date);
        dayEnd.setHours(23);
        dayEnd.setMinutes(60);
        dayEnd.setSeconds(60);
        return this.orderRepository.findAllByDateBetween(dayStart,dayEnd);
    }



    @Override
    public Float totalEarningInOneDay(String date) throws ParseException {
        //find orders in one day
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dayStart=simpleDateFormat.parse(date);
        Date dayEnd=simpleDateFormat.parse(date);
        dayEnd.setHours(23);
        dayEnd.setMinutes(60);
        dayEnd.setSeconds(60);
        List<Order>list= this.orderRepository.findAllByDateBetween(dayStart,dayEnd);

        float priviousSum=0f;
        List<Float> totalEarning=list.stream().map(element->element.getTotalCost()+priviousSum).collect(Collectors.toList());
        float temp=totalEarning.stream().reduce(0f,(a,b)->a+b);
        return temp;

    }

    @Override
    public Float dailyEarningAtOnePos(@PathVariable("posId") String posId) {

        List<Order>list=this.orderRepository.findAllByPosId(posId);
        float totalCost=0f;

        List<Float> tempTotalCost= list.stream().map(element -> element.getTotalCost()).collect(Collectors.toList());
        return tempTotalCost.stream().reduce(0f,(a,b)->a+b);


    }


}
