package com.Test.demo.infrastructure.adapter.persistance;

import com.Test.demo.infrastructure.entity.CoderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatabaseRepo extends JpaRepository<CoderEntity, UUID> {

}
