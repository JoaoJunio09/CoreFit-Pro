package br.com.joaojuniodev.corefitpro.personalTrainer.controller;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.request.PersonalTrainerRequestDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.service.PersonalTrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personalTrainers/v1")
public class PersonalTrainerController {

    private final PersonalTrainerService personalTrainerService;

    public PersonalTrainerController(PersonalTrainerService personalTrainerService) {
        this.personalTrainerService = personalTrainerService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalTrainerResponseDTO>> getAll() {
        return ResponseEntity.ok().body(personalTrainerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalTrainerResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personalTrainerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PersonalTrainerResponseDTO> create(@RequestBody PersonalTrainerRequestDTO personalTrainer) {
        return ResponseEntity.ok().body(personalTrainerService.create(personalTrainer));
    }

    @PutMapping
    public ResponseEntity<PersonalTrainerResponseDTO> update(@RequestBody PersonalTrainerRequestDTO personalTrainer) {
        return ResponseEntity.ok().body(personalTrainerService.update(personalTrainer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        personalTrainerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}