package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.Warehouse;
import com.assetmanagement.exception.WarehouseNotFoundException;
import com.assetmanagement.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	private WarehouseRepository warehouseRepository;
	

	@Override
	public Warehouse saveWarehouse(Warehouse warehouse) {
		Warehouse savedWarehouse=warehouseRepository.save(warehouse);
		return savedWarehouse;
	}

	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) {
		Optional<Warehouse> optional =warehouseRepository.findById(warehouse.getWarehouseId());
		if(optional.isEmpty()) {
			throw new WarehouseNotFoundException("Warehouse not found with Id"+warehouse.getWarehouseId());
		}
		
		return warehouseRepository.save(warehouse);
	}

	@Override
	public void deleteWarehouse(int warehouseId) {
		Optional<Warehouse>optional=warehouseRepository.findById(warehouseId);
		if(optional.isEmpty()) {
			throw new WarehouseNotFoundException("Warehouse not found with Id : "+warehouseId);
		}
		warehouseRepository.deleteById(warehouseId);
	}

	@Override
	public List<Warehouse> getAllWarehouse() {
		
		List<Warehouse> allList= warehouseRepository.findAll();
		if(allList.isEmpty()) {
			throw new WarehouseNotFoundException("Sorry no warehouses available...!");
		}
		return allList;
	}

	@Override
	public Warehouse getWarehouseById(int warehouseId) {
		Optional<Warehouse> optional= warehouseRepository.findById(warehouseId);
		if(optional.isEmpty()) {
			throw new WarehouseNotFoundException("Warehouse not found with Id : "+warehouseId);
		}
		Warehouse warehouse=optional.get();
		return warehouse;
	}

	@Override
	public Warehouse getByWarehouseName(String warehouseName) {
		
		Optional<Warehouse> optional=warehouseRepository.findByWarehouseName(warehouseName);
		
		if(optional.isEmpty()) {
			throw new WarehouseNotFoundException("Warehouse not found with Name : "+warehouseName);
		}
		
		Warehouse warehouse=optional.get();
		return warehouse;
	}

	@Override
	public List<Warehouse> getWarehousesByLocation(String location) {
		
		List<Warehouse> warehouses = warehouseRepository.findByWarehouseLocation(location);
		
		if(warehouses.isEmpty()) {
		throw new WarehouseNotFoundException("Warehouse not found with this location : " + location);

		 }
		
		return warehouses;
	}

}