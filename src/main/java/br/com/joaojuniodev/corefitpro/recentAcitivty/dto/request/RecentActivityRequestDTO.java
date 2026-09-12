package br.com.joaojuniodev.corefitpro.recentAcitivty.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record RecentActivityRequestDTO(
    UUID id,
    LocalDateTime registeredAt,
    String description
) {}