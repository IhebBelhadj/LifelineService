package org.eldsync.lifelineservice2.services;

import org.eldsync.lifelineservice2.DTOs.req.PeerInput;
import org.eldsync.lifelineservice2.entities.Peer;

import java.util.List;

public interface PeerService {
    Peer getPeerWithId(Long peerId);
    List<Peer> getPeersByName(String peerName);
    Peer createPeer(PeerInput peerData);
    Peer updatePeer(Long peerId, PeerInput peerUpdates);
    String deletePeer(Long peerId);
}