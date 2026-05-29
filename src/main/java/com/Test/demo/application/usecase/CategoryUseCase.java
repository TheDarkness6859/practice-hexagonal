package com.Test.demo.application.usecase;

import com.Test.demo.application.port.in.CategoryInPort;
import com.Test.demo.application.port.out.CategoryOutPort;
import com.Test.demo.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryUseCase implements CategoryInPort {

    private final CategoryOutPort categoryOutPort;


    public CategoryUseCase (CategoryOutPort categoryOutPort){
        this.categoryOutPort = categoryOutPort;
    }

    @Override
    public List<Category> getAll () {

        return categoryOutPort.getAll();

    }

    @Override
    public Category getById (UUID id){

        return categoryOutPort.getById(id);

    }

    @Override
    public Category save (Category category){

        return categoryOutPort.save(category);

    }

    @Override
    public boolean delete (UUID id){

        return categoryOutPort.delete(id);

    }

    @Override
    public Category edit (UUID id, Category category){

        Category exists = categoryOutPort.getById(id);

        if (exists != null){

            exists.setId(id);

            return categoryOutPort.save(category);

        }

        return null;

    }
}
