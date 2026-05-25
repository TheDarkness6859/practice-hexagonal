package com.Test.demo.infrastructure.dto;

import com.Test.demo.domain.Coder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClanSharedDto {

    private UUID id;
    private String name;
    private String description;
    private List<CoderSharedDto> coders = new ArrayList<>();

}
