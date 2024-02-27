package com.eldsync.lifelineservice.services;

import com.eldsync.lifelineservice.DTOs.req.PeerInput;
import com.eldsync.lifelineservice.entities.Peer;

import java.util.List;

public interface PeerService {
    Peer getPeerWithId(Long peerId);
    List<Peer> getPeersByName(String peerName);
    Peer createPeer(PeerInput peerData);
    Peer updatePeer(Long peerId, PeerInput peerUpdates);
    String deletePeer(Long peerId);
}