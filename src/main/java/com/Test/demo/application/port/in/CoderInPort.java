package com.Test.demo.application.port.in;

import com.Test.demo.domain.Coder;

import java.util.List;

public interface CoderInPort {

    List<Coder> getAll ();

    Coder save (Coder coder);

    boolean delete (Long id);

    Coder edit (Long id, Coder coder);

}
