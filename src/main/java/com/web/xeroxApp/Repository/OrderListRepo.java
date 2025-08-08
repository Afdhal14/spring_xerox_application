package com.web.xeroxApp.Repository;

import com.web.xeroxApp.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepo extends JpaRepository<OrderList,Integer> {

    public List<OrderList> findByShopId(int shopId);

    public List<OrderList> findByRollNo(int rollNo);

    public OrderList findByOrderId(int orderId);
}
