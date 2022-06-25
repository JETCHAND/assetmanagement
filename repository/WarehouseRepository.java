package com.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assetmanagement.entity.Warehouse;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer>{
	public Optional<Warehouse> findByWarehouseName(String warehouseName);
	List<Warehouse> findByWarehouseLocation(String warehouseLocation);	
}
