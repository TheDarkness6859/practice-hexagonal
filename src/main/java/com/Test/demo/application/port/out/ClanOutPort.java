package com.Test.demo.application.port.out;

import com.Test.demo.domain.Clan;

import java.util.List;
import java.util.UUID;

public interface ClanOutPort {

    List<Clan> getAll ();

    Clan getById(UUID id);

    Clan save (Clan clan);

    boolean delete (UUID id);

}
