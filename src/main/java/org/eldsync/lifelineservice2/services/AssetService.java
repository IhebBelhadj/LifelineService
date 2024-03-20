package org.eldsync.lifelineservice2.services;


import org.eldsync.lifelineservice2.DTOs.req.AssetInput;
import org.eldsync.lifelineservice2.entities.Asset;

public interface AssetService {
    Asset getAssetWithId(Long assetId);
    Asset createAsset(AssetInput assetData);
    String deleteAsset(Long assetId);
}
