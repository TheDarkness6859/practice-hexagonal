package com.Test.demo.infrastructure.adapter.out;

import com.Test.demo.aplication.port.out.CoderOutPort;
import com.Test.demo.domain.Coder;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoderOutAdapter implements CoderOutPort {

    private final List<Entity> db = new ArrayList<>();
    private final

    @Override
    public boolean save (Coder coder){



    }

}
