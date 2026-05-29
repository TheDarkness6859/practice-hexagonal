package com.Test.demo.infrastructure.adapter.out;

import com.Test.demo.application.port.out.ClanOutPort;
import com.Test.demo.domain.Clan;
import com.Test.demo.infrastructure.adapter.persistance.DatabaseRepo;
import com.Test.demo.infrastructure.entity.ClanEntity;
import com.Test.demo.infrastructure.mapper.ClanMapper;

import java.util.List;
import java.util.UUID;

public class ClanOutAdapter implements ClanOutPort {

    private final DatabaseRepo<ClanEntity> repo;
    private final ClanMapper mapper;

    public ClanOutAdapter (DatabaseRepo<ClanEntity> repo, ClanMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Clan> getAll(){

        return repo.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

    @Override
    public Clan getById (UUID id){

        return repo.findById(id)
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .map(mapper::toDomain)
                .orElse(null);

    }

    @Override
    public Clan save(Clan clan){

        ClanEntity entity = mapper.toEntity(clan);

        ClanEntity savedEntity = repo.save(entity);

        return mapper.toDomain(savedEntity);

    }

    @Override
    public boolean delete (UUID id){

        if (repo.existsById(id)){

            repo.deleteById(id);
            return true;

        }

        return false;

    }

}
