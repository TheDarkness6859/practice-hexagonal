package com.Test.demo.infrastructure.dto;

import java.util.List;
import java.util.UUID;

public record ClanSharedDto (UUID id, String name, String description, List<CoderSharedDto> coders){}
