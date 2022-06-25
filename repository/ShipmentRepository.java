package com.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetmanagement.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

}