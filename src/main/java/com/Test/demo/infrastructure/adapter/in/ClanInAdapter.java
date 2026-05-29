package com.Test.demo.infrastructure.adapter.in;

import com.Test.demo.application.port.in.ClanInPort;
import com.Test.demo.domain.Clan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clans")
public class ClanInAdapter {

    private final ClanInPort clanInPort;

    public ClanInAdapter (ClanInPort clanInPort){
        this.clanInPort = clanInPort;
    }

    @GetMapping
    public ResponseEntity<List<Clan>> getAll(){

        return ResponseEntity.ok(clanInPort.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Clan> getById (@PathVariable UUID id){

        Clan clan = clanInPort.getById(id);

        if (clan != null){

            return ResponseEntity.ok(clan);

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Clan> save(@RequestBody Clan clan){

        Clan savedClan = clanInPort.save(clan);

        return new ResponseEntity<>(savedClan, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable UUID id, @RequestBody Clan clan){

        Clan editedclan = clanInPort.edit(id, clan);

        if (editedclan != null){

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable UUID id){

        boolean deletedClan = clanInPort.delete(id);

        if (deletedClan){

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}
