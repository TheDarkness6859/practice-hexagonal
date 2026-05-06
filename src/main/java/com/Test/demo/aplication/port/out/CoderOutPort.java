package com.Test.demo.aplication.port.out;

import java.util.List;

public interface CoderOutPort {

    List<Coder> getAll ();
    boolean save (Coder coder);
    boolean delete (Long id);

}
