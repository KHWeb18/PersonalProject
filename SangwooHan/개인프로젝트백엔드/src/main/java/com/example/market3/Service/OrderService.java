package com.example.market3.Service;

import com.example.market3.Entity.JpaOrder;

import java.util.List;

public interface OrderService {

    public void register(JpaOrder jpaOrder)throws  Exception;

    public List<JpaOrder> getOrderList() throws  Exception;

    public  void Shipping(Long orderNo,String Shipping)throws  Exception;

    public  void QuantityChange(Long orderNo, Integer Quantity) throws  Exception;

    public  void deleteOrder(Long orderNo) throws  Exception;

    public  List<JpaOrder> getorderlist(String userid) throws  Exception;




}
