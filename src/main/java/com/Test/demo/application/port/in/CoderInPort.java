package com.Test.demo.application.port.in;

import com.Test.demo.domain.Coder;

import java.util.List;
import java.util.UUID;

public interface CoderInPort {

    List<Coder> getAll ();

    Coder getById (UUID id);

    Coder save (Coder coder);

    boolean delete (UUID id);

    Coder edit (UUID id, Coder coder);

}
