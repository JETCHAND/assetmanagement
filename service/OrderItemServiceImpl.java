package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.OrderItem;
import com.assetmanagement.exception.OrderItemNotFoundException;
import com.assetmanagement.repository.OrderItemRepository;



@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	

	
	/*@Override
	public OrderItem addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
			
			OrderItem saveOrderItem = orderItemRepository.save(orderItem);
			return saveOrderItem;
		
		
	}*/

	@Override
	public OrderItem getOrderItemById(int orderItemId) throws OrderItemNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);		
		
		if(optionalOrderItem.isEmpty()) {
			
			throw new OrderItemNotFoundException("OrderItem Not found with id: "+orderItemId);
		}
		
		OrderItem orderItem = optionalOrderItem.get();
		return orderItem;
		
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		// TODO Auto-generated method stub
		List<OrderItem> orderItems = orderItemRepository.findAll();
		return orderItems;
	
		
	}

	

	/*@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		Optional<OrderItem> optionalOrderItem =  orderItemRepository.findById(orderItem.getOrderItemId());
		
		if(optionalOrderItem.isEmpty()) {
			throw new OrderItemNotFoundException("OrderItem Not found with id: "+orderItem.getOrderItemId());
		}
		
		OrderItem updatedOrderItem = orderItemRepository.save(orderItem);
		return updatedOrderItem;
	}*/

	/*@Override
	public void deleteOrderItemById(int orderItemId) {
		// TODO Auto-generated method stub
		Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
		if(optionalOrderItem.isEmpty()) {
			throw new OrderItemNotFoundException("OrderItem Not found with id: "+orderItemId);
		}
		
		orderItemRepository.deleteById(orderItemId);		
		
	}*/

}
