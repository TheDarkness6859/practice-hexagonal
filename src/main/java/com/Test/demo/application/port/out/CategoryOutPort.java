package com.Test.demo.application.port.out;

import com.Test.demo.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryOutPort {

    List<Category> getAll ();

    Category getById(UUID id);

    Category save (Category category);

    boolean delete (UUID id);

}
