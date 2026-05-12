package com.Test.demo.application.port.out;

import com.Test.demo.domain.Coder;

import java.util.List;
import java.util.UUID;

public interface CoderOutPort {

    List<Coder> getAll ();

    Coder getById(UUID id);

    Coder save (Coder coder);

    boolean delete (UUID id);

}
