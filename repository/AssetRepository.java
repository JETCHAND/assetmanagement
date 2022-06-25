package com.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetmanagement.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

	List<Asset> findByAssetName(String assetName);

	List<Asset> findByAssetPrice(double assetPrice);

	List<Asset> findByAssetCategory(String assetCategory);

	List<Asset> findByAssetType(String assetType);
}
