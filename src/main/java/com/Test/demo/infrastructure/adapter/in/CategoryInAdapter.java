package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.CategoryInPort;
import com.Test.demo.domain.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryInAdapter {

    private final CategoryInPort categoryInPort;

    public CategoryInAdapter (CategoryInPort categoryInPort){
        this.categoryInPort = categoryInPort;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll () {

        return  ResponseEntity.ok(categoryInPort.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById (@PathVariable UUID id){

        Category category = categoryInPort.getById(id);

        if (category != null){

            return ResponseEntity.ok(category);

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Category> save (@RequestBody Category category){

        Category createdCategory = categoryInPort.save(category);

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit (@PathVariable UUID id, @RequestBody Category category){

        Category editedCategory = categoryInPort.edit(id, category);

        if (editedCategory != null){

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable UUID id){

        boolean deletedCategory = categoryInPort.delete(id);

        if (deletedCategory){

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}
