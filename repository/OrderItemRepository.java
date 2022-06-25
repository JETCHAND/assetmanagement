package com.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetmanagement.entity.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{
	
	
}
