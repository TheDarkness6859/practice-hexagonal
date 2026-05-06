package com.Test.demo.aplication.port.out;

import com.Test.demo.domain.Coder;

import java.util.List;

public interface CoderOutPort {

    List<Coder> getAll ();
    boolean save (Coder coder);
    boolean delete (Long id);

}
