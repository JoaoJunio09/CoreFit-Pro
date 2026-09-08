package br.com.joaojuniodev.corefitpro.trainingPlain.controller;

import br.com.joaojuniodev.corefitpro.trainingPlain.dto.request.TrainingPlainRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.dto.response.TrainingPlainResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingPlain.service.TrainingPlainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trainingsPlans/v1")
public class TrainingPlainController {

    private final TrainingPlainService trainingPlainService;

    public TrainingPlainController(TrainingPlainService trainingPlainService) {
        this.trainingPlainService = trainingPlainService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingPlainResponseDTO>> getAll() {
        return ResponseEntity.ok().body(trainingPlainService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlainResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(trainingPlainService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TrainingPlainResponseDTO> create(@RequestBody TrainingPlainRequestDTO trainingPlain) {
        return ResponseEntity.ok().body(trainingPlainService.create(trainingPlain));
    }

    @PutMapping
    public ResponseEntity<TrainingPlainResponseDTO> update(@RequestBody TrainingPlainRequestDTO trainingPlain) {
        return ResponseEntity.ok().body(trainingPlainService.update(trainingPlain));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        trainingPlainService.delete(id);
        return ResponseEntity.noContent().build();
    }
}