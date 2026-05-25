package com.Test.demo.application.port.in;

import com.Test.demo.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryInPort {

    List<Category> getAll ();

    Category getById (UUID id);

    Category save (Category category);

    boolean delete (UUID id);

    Category edit (UUID id, Category category);

}
