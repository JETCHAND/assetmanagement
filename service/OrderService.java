package com.assetmanagement.service;

import java.util.List;
import java.util.Set;

import com.assetmanagement.entity.Order;
import com.assetmanagement.entity.OrderItem;

public interface OrderService {
	
	public Order saveOrder(int userId,int toWarehouseId,int fromWarehouseId,Set<OrderItem> orderItems);

	public void cancelOrderById(int orderId);
	
	public Order getOrderById(int orderId);
	
	public List<Order> getAll(); 
}
