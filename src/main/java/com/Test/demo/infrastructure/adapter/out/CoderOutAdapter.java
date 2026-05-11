package com.Test.demo.infrastructure.adapter.out;

import com.Test.demo.application.port.out.CoderOutPort;
import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.entity.CoderEntity;
import com.Test.demo.infrastructure.mapper.CoderMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoderOutAdapter implements CoderOutPort {

    private final List<CoderEntity> db = new ArrayList<>();
    private final CoderMapper mapper;

    public CoderOutAdapter (CoderMapper mapper){

        this.mapper = mapper;

    }

    @Override
    public List<Coder> getAll() {

        return db.stream()
                .map(mapper::toDomain)
                .toList()
        ;


    }

    @Override
    public Coder getById (Long id){

        return db.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(mapper::toDomain)
                .orElse(null)
        ;

    }

    @Override
    public Coder save (Coder coder){

        CoderEntity entity = mapper.toEntity(coder);

        db.removeIf(e -> e.getId().equals(entity.getId()));
        db.add(entity);

        return mapper.toDomain(entity);

    }

    @Override
    public boolean delete(Long id) {

        return db.removeIf(e -> e.getId().equals(id));

    }

}
