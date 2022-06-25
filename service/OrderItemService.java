package com.assetmanagement.service;

import java.util.List;

import com.assetmanagement.entity.OrderItem;

public interface OrderItemService {

	//OrderItem addOrderItem(OrderItem orderitem);
	
	OrderItem getOrderItemById(int orderItemId);
	
	List<OrderItem>getAllOrderItem();
	
	
	//OrderItem updateOrderItem(OrderItem orderItem);
	
	//void deleteOrderItemById(int orderItemId);


	
}
