package com.Test.demo.application.port.out;

import com.Test.demo.domain.Coder;

import java.util.List;

public interface CoderOutPort {

    List<Coder> getAll ();

    Coder getById(Long id);

    Coder save (Coder coder);

    boolean delete (Long id);

}
