package com.assetmanagement.model;

import java.util.List;

public class OrderRequest {
															          
	private List<OrderAssetQuantity> orderAssetQuantity;
	
		private int userId;
	
		private int toWarehouseId;
	
	
	private int fromWarehouseId;	 
	
	public int getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(int toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public int getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(int fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public List<OrderAssetQuantity> getOrderAssetQuantity() {
		return orderAssetQuantity;
	}

	public void setOrderAssetQuantity(List<OrderAssetQuantity> orderAssetQuantity) {
		this.orderAssetQuantity = orderAssetQuantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	 
}
