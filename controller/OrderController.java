package com.assetmanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.entity.Order;
import com.assetmanagement.entity.OrderItem;
import com.assetmanagement.model.OrderAssetQuantity;
import com.assetmanagement.model.OrderRequest;
import com.assetmanagement.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	ResponseEntity<Object> responseEntity = null;
	
	
	@PostMapping("/order/save")
	public ResponseEntity<Object> makeOrder(@Valid @RequestBody OrderRequest orderRequest) {
		
		List<OrderAssetQuantity> orderQuantity = orderRequest.getOrderAssetQuantity();
		
		int userId = orderRequest.getUserId();
		
		int toWarehouseId = orderRequest.getToWarehouseId();
		int fromWarehouseId = orderRequest.getFromWarehouseId();
	
		Set<OrderItem> orderItems = new HashSet	<>();
				
		orderQuantity.forEach(r->{
			OrderItem orderItem = new OrderItem();
			orderItem.setAssetId(r.getAssetId());
			orderItem.setQuantity(r.getAssetQuantity());
			orderItems.add(orderItem);
		});
		
		Order newOrder = orderService.saveOrder(userId,toWarehouseId,fromWarehouseId, orderItems);
		 
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/order/getById/{oId}")
	public ResponseEntity<Object> searchById(@PathVariable("oId") int orderId) {
		Order order = orderService.getOrderById(orderId);
		responseEntity = new ResponseEntity<>(order,HttpStatus.FOUND);
		return responseEntity;
		
	}
	
	@GetMapping("/order/getAll")
	public List<Order> getAllOrders() {
		 return orderService.getAll();
		
	}
	
	@DeleteMapping("/order/cancel/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable("orderId") int orderId) {
		orderService.cancelOrderById(orderId);
		 
		return new ResponseEntity<>("Order Successfully Cancelled",HttpStatus.GONE);
	}
}
