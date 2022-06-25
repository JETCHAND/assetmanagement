package com.assetmanagement.service;

import java.util.List;

import com.assetmanagement.entity.Shipment;

public interface ShipmentService {
	public Shipment saveShipment(Shipment shipment);

	public Shipment getShipmentById(int shipId);

	public List<Shipment> getAllShipment();

	public Shipment updateShipment(Shipment shipment);

	public void deleteShipmentById(int shipId);

}