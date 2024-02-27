package com.eldsync.lifelineservice.graphQl.resolvers;

import com.eldsync.lifelineservice.DTOs.req.AssetInput;
import com.eldsync.lifelineservice.entities.Asset;
import com.eldsync.lifelineservice.entities.Note;
import com.eldsync.lifelineservice.services.AssetService;
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