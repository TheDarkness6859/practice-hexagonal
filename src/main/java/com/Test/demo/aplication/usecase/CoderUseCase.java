package com.Test.demo.aplication.usecase;

import com.Test.demo.aplication.port.in.CoderInPort;
import com.Test.demo.aplication.port.out.CoderOutPort;
import com.Test.demo.domain.Coder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoderUseCase implements CoderInPort {

    private final CoderOutPort coderOutPort;

    public CoderUseCase (CoderOutPort coderOutPort){

        this.coderOutPort = coderOutPort;

    }

    @Override
    public boolean save (Coder coder){

        coderOutPort.save(coder);
        return true;

    }

    @Override
    public List<Coder> getAll () {

        return coderOutPort.getAll();

    }

    @Override
    public boolean delete (Long id){

        return coderOutPort.delete(id);

    }

}
