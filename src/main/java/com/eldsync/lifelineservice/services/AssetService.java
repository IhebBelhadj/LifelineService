package com.eldsync.lifelineservice.services;

import com.eldsync.lifelineservice.DTOs.req.AssetInput;
import com.eldsync.lifelineservice.entities.Asset;


public interface AssetService {
    Asset getAssetWithId(Long assetId);
    Asset createAsset(AssetInput assetData);
    String deleteAsset(Long assetId);
}
