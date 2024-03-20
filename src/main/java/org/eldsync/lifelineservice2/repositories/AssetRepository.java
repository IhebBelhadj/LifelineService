package org.eldsync.lifelineservice2.repositories;

import org.eldsync.lifelineservice2.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
