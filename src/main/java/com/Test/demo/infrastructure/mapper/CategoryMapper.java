package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Category;
import com.Test.demo.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryEntity toEntity (Category domain){

        CategoryEntity entity = new CategoryEntity();

        entity.setId(domain.getId());
        entity.setName(domain.getName());

        return entity;

    }

    public Category toDomain (CategoryEntity entity){

        Category domain = new Category();

        domain.setId(entity.getId());
        domain.setName(entity.getName());

        return domain;

    }

}
