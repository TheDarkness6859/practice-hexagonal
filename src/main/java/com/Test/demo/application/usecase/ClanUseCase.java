package com.Test.demo.application.usecase;

import com.Test.demo.application.port.in.ClanInPort;
import com.Test.demo.application.port.out.ClanOutPort;
import com.Test.demo.domain.Clan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClanUseCase implements ClanInPort {

    private final ClanOutPort clanOutPort;

    public ClanUseCase (ClanOutPort clanOutPort){

        this.clanOutPort = clanOutPort;

    }

    @Override
    public List<Clan> getAll () {

        return clanOutPort.getAll();

    }

    @Override
    public Clan getById (UUID id){

        return clanOutPort.getById(id);

    }

    @Override
    public Clan save (Clan clan){

        return clanOutPort.save(clan);

    }

    @Override
    public boolean delete (UUID id){

        return clanOutPort.delete(id);

    }

    @Override
    public Clan edit (UUID id, Clan clan){

        Clan clanExists = clanOutPort.getById(id);

        if (clanExists != null){

            clanExists.setId(id);

            return clanOutPort.save(clan);

        }

        return null;

    }

}
