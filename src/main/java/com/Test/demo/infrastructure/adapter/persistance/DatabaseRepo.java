package com.Test.demo.infrastructure.adapter.persistance;

import com.Test.demo.infrastructure.entity.CoderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface DatabaseRepo<T> extends JpaRepository<T, UUID> {

}
