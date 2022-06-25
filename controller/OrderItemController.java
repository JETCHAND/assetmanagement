package com.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.entity.OrderItem;
import com.assetmanagement.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
	/*@PostMapping("/orderItem/save")
	public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem) {
		
		OrderItem newOrderItem = orderItemService.addOrderItem(orderItem);		
		ResponseEntity<OrderItem> responseEntity = new ResponseEntity<>(newOrderItem,HttpStatus.CREATED);
		return responseEntity;
	}*/
	@GetMapping("/orderItem/find/{orderItemId}")
	public ResponseEntity<Object> fetchOrderItemById(@PathVariable("orderItemId") int orderItemId) {
		
		ResponseEntity<Object> responseEntity = null;		
		OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);	
		responseEntity = new ResponseEntity<>(orderItem,HttpStatus.OK);				
		return responseEntity;
	}
	/*@DeleteMapping("/orderItem/delete/{orderItemId}")
	public ResponseEntity<String> removeOrderItem(@PathVariable("orderItemId") int orderItemId) {
		
		orderItemService.deleteOrderItemById(orderItemId);		
		ResponseEntity<String> responseEntity = new ResponseEntity<>("orderItem Deleted Successfully.", HttpStatus.OK);
		return responseEntity;		
	}*/
	
	/*@PutMapping("/orderItem/update")
	public ResponseEntity<OrderItem> modifyProduct(@RequestBody OrderItem orderItem) {
		
		OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);	
		ResponseEntity<OrderItem> responseEntity = new ResponseEntity<>(updatedOrderItem,HttpStatus.OK);
		return responseEntity;
	}	*/
}
