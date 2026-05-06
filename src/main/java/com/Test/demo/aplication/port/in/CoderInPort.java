package com.Test.demo.aplication.port.in;

import com.Test.demo.domain.Coder;

import java.util.List;

public interface CoderInPort {

    List<Coder> getAll ();
    boolean save (Coder coder);
    boolean delete (Long id);

}
