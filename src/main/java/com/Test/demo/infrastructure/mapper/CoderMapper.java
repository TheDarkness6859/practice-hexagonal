package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.entity.CoderEntity;
import org.springframework.stereotype.Component;

@Component
public class CoderMapper {

    public CoderEntity toEntity (Coder domain){

        return new CoderEntity(domain.getId(), domain.getName(), domain.getClan());

    }

    public Coder toDomain (CoderEntity entity){

        return new Coder(entity.getId(), entity.getName(), entity.getClan());

    }

}
