package br.com.joaojuniodev.corefitpro.training.controller;

import br.com.joaojuniodev.corefitpro.training.dto.request.TrainingRequestDTO;
import br.com.joaojuniodev.corefitpro.training.dto.response.TrainingResponseDTO;
import br.com.joaojuniodev.corefitpro.training.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trainings/v1")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingResponseDTO>> getAll() {
        return ResponseEntity.ok().body(trainingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(trainingService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TrainingResponseDTO> create(@RequestBody TrainingRequestDTO training) {
        return ResponseEntity.ok().body(trainingService.create(training));
    }

    @PutMapping
    public ResponseEntity<TrainingResponseDTO> update(@RequestBody TrainingRequestDTO training) {
        return ResponseEntity.ok().body(trainingService.update(training));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        trainingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}