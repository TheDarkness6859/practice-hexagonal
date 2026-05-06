package com.Test.demo.aplication.port.in;

import java.util.List;

public interface CoderInPort {

    List<Coder> getAll ();
    boolean save (Coder coder);
    boolean delete (Long id);

}
