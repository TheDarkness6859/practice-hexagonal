package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Category;
import com.Test.demo.domain.Clan;
import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.dto.CategorySharedDto;
import com.Test.demo.infrastructure.dto.ClanSharedDto;
import com.Test.demo.infrastructure.dto.CoderSharedDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DtoMapper {

    public CoderSharedDto toSharedDto (Coder domain){

        return new CoderSharedDto(
                domain.getId(),
                domain.getName(),
                domain.getActive()
        );

    }

    public ClanSharedDto toClanDto (Clan domain){

        ClanSharedDto dto = new ClanSharedDto();

        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setDescription(domain.getDescription());

        if (domain.getCoders() != null){

            dto.setCoders(
                    domain.getCoders()
                            .stream()
                            .map(this::toSharedDto)
                            .collect(Collectors.toList()))
            ;

        }

        return dto;

    }

    public CategorySharedDto toCategoryDto (Category domain){

        CategorySharedDto dto = new CategorySharedDto();

        dto.setId(domain.getId());
        dto.setName(domain.getName());

        if (domain.getCoders() != null){

            dto.setCoders(
                    domain.getCoders()
                            .stream()
                            .map(this::toSharedDto)
                            .collect(Collectors.toSet()))
            ;

        }

        return dto;

    }

}
