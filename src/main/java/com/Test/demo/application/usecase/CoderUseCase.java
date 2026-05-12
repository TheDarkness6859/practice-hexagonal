package com.Test.demo.application.usecase;

import com.Test.demo.application.port.in.CoderInPort;
import com.Test.demo.application.port.out.CoderOutPort;
import com.Test.demo.domain.Coder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CoderUseCase implements CoderInPort {

    private final CoderOutPort coderOutPort;

    public CoderUseCase (CoderOutPort coderOutPort){

        this.coderOutPort = coderOutPort;

    }

    @Override
    public Coder save (Coder coder){

        return coderOutPort.save(coder);

    }

    @Override
    public List<Coder> getAll () {

        return coderOutPort.getAll();

    }

    @Override
    public Coder getById (UUID id){

        return coderOutPort.getById(id);

    }

    @Override
    public boolean delete (UUID id){

        return coderOutPort.delete(id);

    }

    @Override
    public Coder edit (UUID id, Coder coder){

        Coder exist = coderOutPort.getById(id);

        if (exist != null){

            coder.setId(id);

            return coderOutPort.save(coder);

        }

        return null;

    }

}
