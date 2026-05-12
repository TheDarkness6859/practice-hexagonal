package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.CoderInPort;
import com.Test.demo.domain.Coder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/coders")
public class CoderInAdapter {

    private final CoderInPort coderInPort;

    public CoderInAdapter(CoderInPort coderInPort){

        this.coderInPort = coderInPort;

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Coder>> getAll () {

        return ResponseEntity.ok(coderInPort.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Coder> getById(@PathVariable UUID id){

        Coder coder = coderInPort.getById(id);

        if (coder != null){

            return ResponseEntity.ok(coder);

        }else {

            return ResponseEntity.notFound().build();

        }

    }

    @PostMapping
    public ResponseEntity<Coder> save (@RequestBody Coder coder){

        Coder savedCoder = coderInPort.save(coder);

        return new ResponseEntity<>(savedCoder, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable UUID id){

        boolean deletedCoder = coderInPort.delete(id);

        if (deletedCoder){

            return ResponseEntity.noContent().build();

        }else {

            return ResponseEntity.notFound().build();

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Coder> edit (@PathVariable UUID id, @RequestBody Coder coder){

        Coder editCoder = coderInPort.edit(id, coder);

        if (editCoder != null){

            return ResponseEntity.noContent().build();

        }else {

            return ResponseEntity.notFound().build();

        }

    }
}
