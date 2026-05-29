package com.Test.demo.infrastructure.mapper;

import com.Test.demo.domain.Category;
import com.Test.demo.domain.Clan;
import com.Test.demo.domain.Coder;
import com.Test.demo.infrastructure.dto.CategorySharedDto;
import com.Test.demo.infrastructure.dto.ClanSharedDto;
import com.Test.demo.infrastructure.dto.CoderSharedDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    public CoderSharedDto toSharedDto (Coder domain){

        return new CoderSharedDto(
                domain.getId(),
                domain.getName(),
                domain.getActive(),
                domain.getClan() != null ? domain.getClan().getId() : null
        );

    }

    public ClanSharedDto toClanDto (Clan domain){

        List<CoderSharedDto> coders = List.of();

        if (domain.getCoders() != null){

            coders = domain.getCoders()
                            .stream()
                            .map(this::toSharedDto).toList()
            ;

        }

        return new ClanSharedDto(domain.getId(), domain.getName(), domain.getDescription(), coders);

    }

    public CategorySharedDto toCategoryDto (Category domain){

        Set<CoderSharedDto> coders = new HashSet<>();

        if (domain.getCoders() != null){

            coders = domain.getCoders()
                    .stream()
                    .map(this::toSharedDto)
                    .collect(Collectors.toSet())
            ;

        }

        return new CategorySharedDto(domain.getId(), domain.getName(), coders);

    }

}
