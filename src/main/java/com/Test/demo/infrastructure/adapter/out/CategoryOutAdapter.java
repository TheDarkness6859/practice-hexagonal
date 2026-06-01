package com.Test.demo.infrastructure.adapter.out;

import com.Test.demo.application.port.out.CategoryOutPort;
import com.Test.demo.domain.Category;
import com.Test.demo.infrastructure.adapter.persistance.CategoryDatabaseRepo;
import com.Test.demo.infrastructure.entity.CategoryEntity;
import com.Test.demo.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryOutAdapter implements CategoryOutPort {

    private final CategoryDatabaseRepo repo;
    private final CategoryMapper mapper;

    public CategoryOutAdapter (CategoryDatabaseRepo repo, CategoryMapper mapper){
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public List<Category> getAll(){

        return repo.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

    @Override
    public Category getById (UUID id){

        return repo.findById(id)
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst().map(mapper::toDomain)
                .orElse(null);

    }

    @Override
    public Category save (Category category){

        CategoryEntity entity = mapper.toEntity(category);

        CategoryEntity savedEntity = repo.save(entity);

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
