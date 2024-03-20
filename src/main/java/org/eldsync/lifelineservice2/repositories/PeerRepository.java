
package org.eldsync.lifelineservice2.repositories;


import org.eldsync.lifelineservice2.entities.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeerRepository extends JpaRepository<Peer, Long> {
  public List<Peer> findPeersByPeerFullName(String peerName);
}