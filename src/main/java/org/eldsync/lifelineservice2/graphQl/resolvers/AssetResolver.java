package org.eldsync.lifelineservice2.graphQl.resolvers;


import org.eldsync.lifelineservice2.DTOs.req.AssetInput;
import org.eldsync.lifelineservice2.entities.Asset;
import org.eldsync.lifelineservice2.services.AssetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AssetResolver {

    private final AssetService assetService;

    public AssetResolver(AssetService assetService) {
        this.assetService = assetService;
    }

    @QueryMapping
    public Asset getAssetWithId(@Argument Long assetId) {
        return assetService.getAssetWithId(assetId);
    }

    @MutationMapping
    public Asset createAsset(@Argument AssetInput assetData) {
        return assetService.createAsset(assetData);
    }

    @MutationMapping
    public String deleteAsset(@Argument Long assetId) {
        return assetService.deleteAsset(assetId);
    }


}