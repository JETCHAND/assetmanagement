package com.assetmanagement.service;

import java.util.List;

import com.assetmanagement.entity.Asset;

public interface AssetService {
	
	Asset addAsset(Asset asset,int warehouseId);

	void deleteAsset(int assetId);

	Asset modifyAsset(Asset asset);

	Asset getAssetById(int assetId);

	List<Asset> getAllAssetsByType(String assetType);

	List<Asset> getAllAssetsByCategory(String assetCategory);

	List<Asset> getAllAssetsByName(String assetName);

	List<Asset> getAllAssetsByPrice(double assetPrice);

	List<Asset> getAllAssets();
}
