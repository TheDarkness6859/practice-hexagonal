package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.CoderInPort;
import com.Test.demo.domain.Coder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coders")
public class CoderInAdapter {

    private final CoderInPort coderInPort;

    public CoderInAdapter(CoderInPort coderInPort){

        this.coderInPort = coderInPort;

    }

    @GetMapping("/getAll")
    public List<Coder> getAll () {

        return coderInPort.getAll();

    }

    @PostMapping
    public Coder save (@RequestBody Coder coder){

        return coderInPort.save(coder);

    }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable Long id){

        return coderInPort.delete(id);

    }

    @PutMapping("/{id}")
    public Coder edit (@PathVariable Long id, @RequestBody Coder coder){

        return coderInPort.edit(id, coder);

    }
}
