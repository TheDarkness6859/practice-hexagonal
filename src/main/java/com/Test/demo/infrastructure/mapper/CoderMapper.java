package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.entity.CoderEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CoderMapper {

    private final ClanMapper clanMapper;
    private final CategoryMapper categoryMapper;

    public CoderMapper (ClanMapper clanMapper, CategoryMapper categoryMapper){
        this.clanMapper = clanMapper;
        this.categoryMapper = categoryMapper;
    }

    public CoderEntity toEntity (Coder domain){

        CoderEntity entity = new CoderEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setClan(clanMapper.toEntity(domain.getClan()));
        entity.setActive(domain.getActive());

        if (domain.getCategories() != null){

            entity.setCategories(

                    domain.getCategories()
                            .stream()
                            .map(categoryMapper::toEntity)
                            .collect(Collectors.toSet()))
            ;

        }

        return entity;

    }

    public Coder toDomain (CoderEntity entity){

        Coder domain = new Coder(
                entity.getId(),
                entity.getName(),
                clanMapper.toDomain(entity.getClan())
        );

        domain.setActive(entity.getActive());

        if (entity.getCategories() != null){

            domain.setCategories(

                    entity.getCategories()
                            .stream()
                            .map(categoryMapper::toDomain)
                            .collect(Collectors.toSet()))
            ;

        }

        return domain;

    }

}
