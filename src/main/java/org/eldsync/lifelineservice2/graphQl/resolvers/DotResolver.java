package org.eldsync.lifelineservice2.graphQl.resolvers;

import org.eldsync.lifelineservice2.DTOs.req.DotInput;

import org.eldsync.lifelineservice2.entities.Asset;
import org.eldsync.lifelineservice2.entities.Dot;
import org.eldsync.lifelineservice2.entities.Peer;
import org.eldsync.lifelineservice2.services.AssetService;
import org.eldsync.lifelineservice2.services.DotService;
import org.eldsync.lifelineservice2.services.PeerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DotResolver {

    private final DotService dotService;
    private final AssetService assetService;
    private final PeerService peerService;

    public DotResolver(DotService dotService, AssetService assetService, PeerService peerService) {
        this.dotService = dotService;
        this.assetService = assetService;
        this.peerService = peerService;
    }

    @QueryMapping
    public Dot getDotWithId(@Argument Long dotId) {
        return dotService.getDotWithId(dotId);
    }

    @MutationMapping
    public Dot createDot(@Argument DotInput dotData) {
        return dotService.createDot(dotData);
    }

    @MutationMapping
    public Dot updateDot(@Argument Long dotId, @Argument DotInput dotUpdates) {

        return dotService.updateDot(dotId, dotUpdates);
    }

    @MutationMapping
    public String deleteDot(@Argument Long dotId) {
        return dotService.deleteDot(dotId);
    }

    @SchemaMapping
    public List<Asset> assets(Dot dot) {
        // Fetch assets associated with the dot using dot ID
        if(dot.getAssets() == null) return List.of();
        List<Long> assetIds = dot.getAssets().stream().map(Asset::getAssetId).toList();
        return assetIds.stream().map(assetService::getAssetWithId).toList();
    }

    @SchemaMapping
    public List<Peer> peers(Dot dot) {
        // Fetch peers associated with the dot using dot ID
        List<Long> peerIds = dot.getPeers().stream().map(Peer::getIdPeer).toList();
        return peerIds.stream().map(peerService::getPeerWithId).toList();
    }
}
