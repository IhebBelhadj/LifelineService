package com.eldsync.lifelineservice.services.impl;

import com.eldsync.lifelineservice.DTOs.req.AssetInput;
import com.eldsync.lifelineservice.entities.Asset;
import com.eldsync.lifelineservice.repositories.AssetRepository;
import com.eldsync.lifelineservice.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset getAssetWithId(Long assetId) {
        Optional<Asset> optionalAsset = assetRepository.findById(assetId);
        return optionalAsset.orElse(null);
    }

    @Override
    public Asset createAsset(AssetInput assetData) {
        Asset asset = new Asset();
        asset.setFileName(assetData.getFileName());
        asset.setFileType(assetData.getFileType());
        asset.setFilePath(assetData.getFilePath());
        asset.setAccessLink(assetData.getAccessLink());
        return assetRepository.save(asset);
    }

    @Override
    public String deleteAsset(Long assetId) {
        Optional<Asset> optionalAsset = assetRepository.findById(assetId);
        if (optionalAsset.isPresent()) {
            assetRepository.deleteById(assetId);
            return "Asset with ID " + assetId + " deleted successfully";
        } else {
            return "Asset with ID " + assetId + " not found";
        }
    }
}