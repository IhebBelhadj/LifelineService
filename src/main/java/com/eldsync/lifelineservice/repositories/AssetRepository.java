package com.eldsync.lifelineservice.repositories;

import com.eldsync.lifelineservice.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
