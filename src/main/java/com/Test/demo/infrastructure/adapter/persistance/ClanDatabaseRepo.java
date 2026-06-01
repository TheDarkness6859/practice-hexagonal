package com.Test.demo.infrastructure.adapter.persistance;

import com.Test.demo.infrastructure.entity.ClanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClanDatabaseRepo extends JpaRepository<ClanEntity, UUID> {
}
