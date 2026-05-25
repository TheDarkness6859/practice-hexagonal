package com.Test.demo.application.port.in;

import com.Test.demo.domain.Clan;

import java.util.List;
import java.util.UUID;

public interface ClanInPort {

    List<Clan> getAll ();

    Clan getById (UUID id);

    Clan save (Clan clan);

    boolean delete (UUID id);

    Clan edit (UUID id, Clan clan);

}
