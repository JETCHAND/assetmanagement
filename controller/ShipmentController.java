package com.assetmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.entity.Shipment;
import com.assetmanagement.service.ShipmentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ShipmentController {

 @Autowired
private ShipmentService shipmentService;

 @PostMapping("shipment/save")
public ResponseEntity<Shipment> addShipment(@Valid @RequestBody Shipment shipment) {
Shipment newShipment = shipmentService.saveShipment(shipment);
ResponseEntity<Shipment> responseEntity = new ResponseEntity<>(newShipment, HttpStatus.CREATED);
return responseEntity;
}

 @GetMapping("/shipment/all")
public List<Shipment> fetchAllShipment() {

 List<Shipment> allShipment = shipmentService.getAllShipment();
return allShipment;
}

 @GetMapping("/shipment/find/{shipmentId}")
public ResponseEntity<Object> fetchById(@PathVariable("shipmentId") int shipId) {

 ResponseEntity<Object> responseEntity = null;
Shipment shipment = shipmentService.getShipmentById(shipId);
responseEntity = new ResponseEntity<>(shipment, HttpStatus.OK);
return responseEntity;
}

 @PutMapping("/shipment/modify")
public ResponseEntity<Shipment> modifyShipment(@RequestBody Shipment shipment) {

 Shipment modifiedShipment = shipmentService.updateShipment(shipment);
ResponseEntity<Shipment> responseEntity = new ResponseEntity<>(modifiedShipment, HttpStatus.OK);
return responseEntity;
}

 @DeleteMapping("shipment/delete/{shipmentId}")
public ResponseEntity<String> deleteShipmentById(@PathVariable("shipmentId") int shipId) {

 shipmentService.deleteShipmentById(shipId);
ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully ", HttpStatus.OK);
return responseEntity;
}

}