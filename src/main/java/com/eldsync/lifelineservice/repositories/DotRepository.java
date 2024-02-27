package com.eldsync.lifelineservice.repositories;

import com.eldsync.lifelineservice.entities.Dot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DotRepository extends JpaRepository<Dot, Long> {
}
