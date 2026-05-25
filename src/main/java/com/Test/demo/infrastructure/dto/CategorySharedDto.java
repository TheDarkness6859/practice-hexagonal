package com.Test.demo.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySharedDto {

    private UUID id;
    private String name;
    private Set<CoderSharedDto> coders = new HashSet<>();

}
