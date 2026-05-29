package com.Test.demo.infrastructure.dto;

import java.util.Set;
import java.util.UUID;

public record CategorySharedDto(UUID id, String name, Set<CoderSharedDto> coders){}
