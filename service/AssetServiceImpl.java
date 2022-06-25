package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.Asset;
import com.assetmanagement.entity.Warehouse;
import com.assetmanagement.exception.AssetNotFoundException;
import com.assetmanagement.exception.WarehouseNotFoundException;
import com.assetmanagement.repository.AssetRepository;
import com.assetmanagement.repository.WarehouseRepository;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;

	@Override
	public void deleteAsset(int assetId) {
		Optional<Asset>optional=assetRepository.findById(assetId);
		if(optional.isEmpty()) {
			throw new AssetNotFoundException("Asset not found withId :"+assetId);
		}
		assetRepository.deleteById(assetId);
	}

	@Override
	public Asset modifyAsset(Asset asset) {
		Optional<Asset> optionalAsset = assetRepository.findById(asset.getAssetId());
		if (optionalAsset.isEmpty()) {
			throw new AssetNotFoundException("Asset Not found with  " + asset.getAssetId() + "Id");
		}
		Asset modifiedAsset = assetRepository.save(asset);
		return modifiedAsset;
	}

	@Override
	public Asset getAssetById(int assetId){
		Optional<Asset> optionalAsset = assetRepository.findById(assetId);
		if (optionalAsset.isEmpty()) {
			throw new AssetNotFoundException("Asset Not found with id: " + assetId);
		}
		Asset assetById = optionalAsset.get();
		return assetById;
	}

	@Override
	public List<Asset> getAllAssetsByName(String assetName) {
		List<Asset> listOfAssetsByName = assetRepository.findByAssetName(assetName);
		if (listOfAssetsByName.size() == 0) {
			throw new AssetNotFoundException("Assets Not found with name: " + assetName);
		}

		return listOfAssetsByName;
	}

	@Override
	public List<Asset> getAllAssetsByPrice(double assetPrice){
		List<Asset> listOfAssetsByPrice = assetRepository.findByAssetPrice(assetPrice);
		if (listOfAssetsByPrice.size() == 0) {
			throw new AssetNotFoundException("Asset Not found with id: " + assetPrice);
		}
		return listOfAssetsByPrice;
	}

	@Override
	public List<Asset> getAllAssetsByCategory(String assetCategory){
		List<Asset> listOfAssetByCategory = assetRepository.findByAssetCategory(assetCategory);
		if (listOfAssetByCategory.size() == 0) {
			throw new AssetNotFoundException("Asset Not found with category: " + assetCategory);
		}
		return listOfAssetByCategory;
	}

	@Override
	public List<Asset> getAllAssetsByType(String assetType) {
		List<Asset> listOfAssetByType = assetRepository.findByAssetType(assetType);
		if (listOfAssetByType.size() == 0) {
			throw new AssetNotFoundException("Asset Not found with type: " + assetType);
		}
		return listOfAssetByType;
	}

	@Override
	public List<Asset> getAllAssets() {
		List<Asset> assets = assetRepository.findAll();
		return assets;
	}
	
	@Override
	public Asset addAsset(Asset asset,int warehouseId) {
		Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
		if(optionalWarehouse.isEmpty()) {
			throw new WarehouseNotFoundException("warehouse not found with :"+warehouseId);
		}
		Warehouse warehouse=optionalWarehouse.get();
		asset.setWarehouse(warehouse);
		return assetRepository.save(asset);
	}
}
