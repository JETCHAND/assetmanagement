package com.assetmanagement.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

import org.checkerframework.common.aliasing.qual.Unique;


@Entity
@Table(name="warehouse_tbl")
public class Warehouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int warehouseId;
	
	@Unique
	@NotEmpty(message="warehouse name can not be blank")
	@Column(nullable=false)
	private String warehouseName;
	
	
	@NotEmpty(message="warehouse location can not be blank")
	@Column(nullable=false)
	private String warehouseLocation;
	
	@OneToMany(mappedBy = "warehouse",cascade=CascadeType.ALL)
    private List<Asset> assets;

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	
}