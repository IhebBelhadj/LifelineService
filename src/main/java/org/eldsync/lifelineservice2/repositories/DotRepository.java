package org.eldsync.lifelineservice2.repositories;

import org.eldsync.lifelineservice2.entities.Dot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DotRepository extends JpaRepository<Dot, Long> {
}
