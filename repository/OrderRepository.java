package com.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetmanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
	

}