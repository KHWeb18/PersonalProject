package com.example.market3.Service;

import com.example.market3.Entity.JpaOrder;
import com.example.market3.Rapository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void register(JpaOrder jpaOrder) throws Exception {
        orderRepository.save(jpaOrder);
    }

    @Override
    public List<JpaOrder> getOrderList() throws Exception {
        return orderRepository.findAll();
    }

    @Override
    public void Shipping(Long orderNo,String Shipping) throws Exception {
        orderRepository.Shipping1(orderNo,Shipping);
    }

    @Override
    public void QuantityChange(Long orderNo, Integer Quantity) throws Exception {
        orderRepository.QuantityChange(orderNo,Quantity);
    }

    @Override
    public void deleteOrder(Long orderNo) throws Exception {
        orderRepository.deleteById(orderNo);
    }

    @Override
    public List<JpaOrder> getorderlist(String userid) throws Exception {
        return orderRepository.getorderlist(userid);
    }
}
