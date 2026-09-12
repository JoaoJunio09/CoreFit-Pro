package br.com.joaojuniodev.corefitpro.recentAcitivty.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record RecentActivityResponseDTO(
    UUID id,
    LocalDateTime registeredAt,
    String description
) {}