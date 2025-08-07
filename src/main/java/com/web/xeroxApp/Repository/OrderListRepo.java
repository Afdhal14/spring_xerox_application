package com.web.xeroxApp.Repository;

import com.web.xeroxApp.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepo extends JpaRepository<OrderList,Integer> {
}
