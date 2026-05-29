package com.Test.demo.infrastructure.dto;

import lombok.NoArgsConstructor;

import java.util.UUID;

public record CoderSharedDto (UUID id, String name, Boolean active, UUID clan) {

    public CoderSharedDto () {
        this(null, null, true, null);
    }

}
