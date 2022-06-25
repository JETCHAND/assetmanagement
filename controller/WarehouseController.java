package com.assetmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.entity.Warehouse;
import com.assetmanagement.service.WarehouseService;

@Validated
@RestController
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("warehouse/all")
	public List<Warehouse> fetchAllWarehouses(){
		List<Warehouse> warehouses=warehouseService.getAllWarehouse();
		return warehouses;
	}
	
	@GetMapping("find/warehouse/{wId}")
	public ResponseEntity<Object> fetchWarehouseById(@PathVariable("wId") int warehouseId){
		ResponseEntity<Object> responseEntity = null;		
		Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);	
		responseEntity = new ResponseEntity<>(warehouse,HttpStatus.OK);				
		return responseEntity;
	}
	
	@GetMapping("/warehouse/find/{wName}")
	public ResponseEntity<Object> fetchProductById(@PathVariable("wName") String warehouseName) {
		
		ResponseEntity<Object> responseEntity = null;		
		Warehouse warehouse = warehouseService.getByWarehouseName(warehouseName);
		responseEntity = new ResponseEntity<>(warehouse,HttpStatus.OK);				
		return responseEntity;
	}
	
	@GetMapping("warehouse/findbylocation/{wLocation}")
	public List<Warehouse> fetchWarehousesByLocation(String location){
		List<Warehouse> warehouses=warehouseService.getWarehousesByLocation(location);
		return warehouses;
	}
	
	@PostMapping("/warehouse/save")
	public ResponseEntity<Warehouse> addWarehouse(@Valid @RequestBody Warehouse warehouse) {
		
		Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);		
		ResponseEntity<Warehouse> responseEntity = new ResponseEntity<>(newWarehouse,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/warehouse/delete/{warehouseId}")
	public ResponseEntity<String> removeProduct(@PathVariable("warehouseId") int warehouseId) {
		
		warehouseService.deleteWarehouse(warehouseId)	;
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Warehouse Deleted Successfully.", HttpStatus.OK);
		return responseEntity;		
	}
	
	@PutMapping("/warehouse/update")
	public ResponseEntity<Warehouse> modifyProduct(@Valid @RequestBody Warehouse warehouse) {
		
		Warehouse updatedProduct = warehouseService.updateWarehouse(warehouse);
		ResponseEntity<Warehouse> responseEntity = new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		return responseEntity;
	}	

}
