package br.com.joaojuniodev.corefitpro.exercise.controller;

import br.com.joaojuniodev.corefitpro.exercise.dto.request.ExerciseRequestDTO;
import br.com.joaojuniodev.corefitpro.exercise.dto.response.ExerciseResponseDTO;
import br.com.joaojuniodev.corefitpro.exercise.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises/v1")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponseDTO>> getAll() {
        return ResponseEntity.ok().body(exerciseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(exerciseService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ExerciseResponseDTO> create(ExerciseRequestDTO exercise) {
        return ResponseEntity.ok().body(exerciseService.create(exercise));
    }

    @PutMapping
    public ResponseEntity<ExerciseResponseDTO> update(ExerciseRequestDTO exercise) {
        return ResponseEntity.ok().body(exerciseService.update(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}