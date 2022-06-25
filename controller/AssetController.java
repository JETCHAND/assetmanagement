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

import com.assetmanagement.entity.Asset;
import com.assetmanagement.service.AssetService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
	public class AssetController {

	@Autowired
	private AssetService assetService;

	@PostMapping("/asset/add/{warehouseId}")
	public ResponseEntity<Asset> addAsset(@Valid @RequestBody Asset asset,@PathVariable int warehouseId) {
		
		Asset newAsset=assetService.addAsset(asset,warehouseId);
		return new ResponseEntity<>(newAsset, HttpStatus.CREATED);
	}

	@DeleteMapping("/asset/delete/{assetId}")
	public ResponseEntity<String> removeAsset(@PathVariable("assetId") int assetId) {

		assetService.deleteAsset(assetId);
		return new ResponseEntity<>("Asset Deleted Successfully.", HttpStatus.OK);
	}

	@PutMapping("/asset/modify")
	public ResponseEntity<Asset> modifyAsset(@RequestBody Asset asset) {

		Asset modifiedAsset = assetService.modifyAsset(asset);
		return new ResponseEntity<>(modifiedAsset, HttpStatus.OK);
	}

	@GetMapping("/asset/find/byId/{assetId}")
	public ResponseEntity<Object> fetchAssetById(@PathVariable("assetId") int assetId) {
		ResponseEntity<Object> responseEntity = null;
		Asset asset = assetService.getAssetById(assetId);
		responseEntity = new ResponseEntity<Object>(asset, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/asset/all/byName/{assetName}")
	public List<Asset> fetchAssetByName(@PathVariable("assetName") String assetName) {		
		return assetService.getAllAssetsByName(assetName);
	}

	@GetMapping("/asset/all/byPrice/{assetPrice}")
	public List<Asset> fetchAssetByPrice(@PathVariable("assetPrice") double assetPrice) {
		return assetService.getAllAssetsByPrice(assetPrice);
	}

	@GetMapping("/asset/all/byCategory/{assetCategory}")
	public List<Asset> fetchAssetByCategory(@PathVariable("assetCategory") String assetCategory) {
		return assetService.getAllAssetsByCategory(assetCategory);
	}

	@GetMapping("/asset/all/byType/{assetType}")
	public List<Asset> fetchAssetByType(@PathVariable("assetType") String assetType) {
		return assetService.getAllAssetsByType(assetType);
	}

	@GetMapping("/asset/all")
	public List<Asset> fetchAllAssets() {
		return assetService.getAllAssets();
	}

	
}
