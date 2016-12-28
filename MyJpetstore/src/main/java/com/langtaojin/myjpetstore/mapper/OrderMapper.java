package com.langtaojin.myjpetstore.mapper;

import java.util.List;

import com.langtaojin.myjpetstore.domain.Order;

public interface OrderMapper {

	List<Order> getOrdersByUsername(String username);
	
	Order getOrder(int orderId);
	
	void insertOrder(Order order);
	
	void insertOrderStatus(Order order);
	
}
