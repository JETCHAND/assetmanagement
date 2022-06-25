package com.assetmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.Order;
import com.assetmanagement.entity.OrderItem;
import com.assetmanagement.entity.User;
import com.assetmanagement.exception.OrderNotFoundException;
import com.assetmanagement.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ShipmentService shipmentService;
	
	@Autowired
	UserService userService;

	@Override
	public Order saveOrder(int userId,int toWarehouseId,int fromWarehouseId,Set<OrderItem> orderItems) {
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		order.setFromWarehouseId(fromWarehouseId);
		order.setToWarehouseId(toWarehouseId);
		
		User user = userService.getUserById(userId);
		order.setUser(user);
	
		order.setOrderitems(orderItems);
		order.setOrderStatus("Successfull"); 
		
		orderItems.forEach(r->{
			r.setOrder(order);
		});
		
		
		return orderRepository.save(order);
	}

	

	@Override
	public void cancelOrderById(int orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if(order.isEmpty()) {
			throw new OrderNotFoundException("Order is not found with id "+orderId);
		}
		orderRepository.deleteById(orderId);
	}

	@Override
	public Order getOrderById(int orderId) {
		Optional<Order> orderById = orderRepository.findById(orderId);
		if(orderById.isEmpty()) {
			throw new OrderNotFoundException("Order Not Found with id "+orderId);
		}
		
		
		return orderById.get();
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}
}