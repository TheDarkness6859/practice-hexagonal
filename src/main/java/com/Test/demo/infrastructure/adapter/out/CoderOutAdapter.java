package com.Test.demo.infrastructure.adapter.out;

import com.Test.demo.application.port.out.CoderOutPort;
import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.adapter.persistance.CoderDatabaseRepo;
import com.Test.demo.infrastructure.entity.CoderEntity;
import com.Test.demo.infrastructure.mapper.CoderMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CoderOutAdapter implements CoderOutPort{

    private final CoderDatabaseRepo repo;
    private final CoderMapper mapper;

    public CoderOutAdapter (CoderMapper mapper, CoderDatabaseRepo repo){
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public List<Coder> getAll() {

        return repo.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList()
        ;


    }

    @Override
    public Coder getById (UUID id){

        return repo.findById(id).stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(mapper::toDomain)
                .orElse(null)
        ;

    }

    @Override
    public Coder save (Coder coder){

        CoderEntity entity = mapper.toEntity(coder);

        CoderEntity savedEntity = repo.save(entity);

        return mapper.toDomain(savedEntity);

    }

    @Override
    public boolean delete(UUID id) {

        if (repo.existsById(id)){

            repo.deleteById(id);
            return true;

        }

        return false;

    }

}
