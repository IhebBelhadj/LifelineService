
package com.eldsync.lifelineservice.repositories;


import com.eldsync.lifelineservice.entities.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerRepository extends JpaRepository<Peer, Long> {

}