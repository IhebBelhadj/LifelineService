package org.eldsync.lifelineservice2.graphQl.resolvers;


import org.eldsync.lifelineservice2.DTOs.req.PeerInput;
import org.eldsync.lifelineservice2.entities.Note;
import org.eldsync.lifelineservice2.entities.Peer;
import org.eldsync.lifelineservice2.services.PeerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PeerResolver {

    private final PeerService peerService;

    public PeerResolver(PeerService peerService) {
        this.peerService = peerService;
    }

    @QueryMapping
    public Peer getPeerWithId(@Argument Long peerId) {
        return peerService.getPeerWithId(peerId);
    }

    @MutationMapping
    public Peer createPeer(@Argument PeerInput peerData) {
        return peerService.createPeer(peerData);
    }

    @MutationMapping
    public Peer updatePeer(@Argument Long peerId, @Argument PeerInput peerUpdates) {
        return peerService.updatePeer(peerId, peerUpdates);
    }

    @MutationMapping
    public String deletePeer(@Argument Long peerId) {
        return peerService.deletePeer(peerId);
    }

    @SchemaMapping
    public List<Note> notes(Peer peer) {
        // Fetch notes associated with the peer
        return peer.getNotes();
    }


}