package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.Shipment;
import com.assetmanagement.exception.ShipmentNotFoundException;
import com.assetmanagement.repository.ShipmentRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService {

 @Autowired
private ShipmentRepository shipmentRepository;

 @Override
public Shipment saveShipment(Shipment shipment) {
Shipment saveShipment = shipmentRepository.save(shipment);
return saveShipment;
}

 @Override
public Shipment getShipmentById(int shipId) throws ShipmentNotFoundException {
Optional<Shipment> optionalShipment = shipmentRepository.findById(shipId);
if (optionalShipment.isEmpty()) {
throw new ShipmentNotFoundException("Shipment not found with this id :" + shipId);
}
Shipment shipmentById = optionalShipment.get();
return shipmentById;
}

 @Override
public List<Shipment> getAllShipment() {
List<Shipment> allShipment = shipmentRepository.findAll();
return allShipment;
}

 @Override
public Shipment updateShipment(Shipment shipment) {
Optional<Shipment> optionalShipment = shipmentRepository.findById(shipment.getShipmentId());
if (optionalShipment.isEmpty()) {
throw new ShipmentNotFoundException("Customer not found with id : " + shipment.getShipmentId());
}
Shipment modifiedShipment = shipmentRepository.save(shipment);
return modifiedShipment;
}

 @Override
public void deleteShipmentById(int shipmentId) {
Optional<Shipment> optionalShipment = shipmentRepository.findById(shipmentId);
if (optionalShipment.isEmpty()) {
throw new ShipmentNotFoundException("Shipment not found with thid id : " + shipmentId);
}

 shipmentRepository.deleteById(shipmentId);
}

}