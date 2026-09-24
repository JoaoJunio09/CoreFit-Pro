package br.com.joaojuniodev.corefitpro.personalTrainer.dto.response;

import br.com.joaojuniodev.corefitpro.personalTrainer.enums.SeverityAttentionEnum;

public record AttentionResponseDTO(
    String traineeName,
    String message,
    String destination,
    SeverityAttentionEnum severity
) {
}