package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Clan;
import com.Test.demo.infrastructure.entity.ClanEntity;
import org.springframework.stereotype.Component;

@Component
public class ClanMapper {

    public ClanEntity toEntity (Clan domain){

        ClanEntity entity = new ClanEntity();

        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());

        return entity;

    }

    public Clan toDomain (ClanEntity entity){

        Clan domain = new Clan();

        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setDescription(entity.getDescription());

        return domain;

    }

}
