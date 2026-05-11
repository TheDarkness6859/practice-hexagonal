package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.domain.Coder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coders")
public class CoderInAdapter {

    private final CoderInAdapter coderInAdapter;

    public CoderInAdapter (CoderInAdapter coderInAdapter){

        this.coderInAdapter = coderInAdapter;

    }

    @GetMapping("/getAll")
    public List<Coder> getAll () {

        return coderInAdapter.getAll();

    }

    @PostMapping
    public boolean save (@RequestBody Coder coder){

        return coderInAdapter.save(coder);

    }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable Long id){

        return coderInAdapter.delete(id);

    }
}
