package com.assetmanagement.model;

import javax.validation.constraints.NotNull;

public class OrderAssetQuantity {

	@NotNull(message = "assetId is required")
	private int assetId;
	private int assetQuantity;
	
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getAssetQuantity() {
		return assetQuantity;
	}
	public void setAssetQuantity(int assetQuantity) {
		this.assetQuantity = assetQuantity;
	}
	
	
}
