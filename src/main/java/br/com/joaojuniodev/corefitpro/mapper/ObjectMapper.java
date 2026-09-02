package br.com.joaojuniodev.corefitpro.mapper;

public interface ObjectMapper<E, D, R> {

    E toEntity(R request);
    D toResponse(E entity);
}