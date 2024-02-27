
package com.eldsync.lifelineservice.repositories;


import com.eldsync.lifelineservice.entities.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeerRepository extends JpaRepository<Peer, Long> {
  public List<Peer> findPeersByPeerFullName(String peerName);
}