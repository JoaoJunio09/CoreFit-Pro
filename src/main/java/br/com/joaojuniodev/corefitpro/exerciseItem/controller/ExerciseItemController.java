package br.com.joaojuniodev.corefitpro.exerciseItem.controller;

import br.com.joaojuniodev.corefitpro.exercise.dto.request.ExerciseRequestDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.request.ExerciseItemRequestDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.dto.response.ExerciseItemResponseDTO;
import br.com.joaojuniodev.corefitpro.exerciseItem.service.ExerciseItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exerciseItems/v1")
public class ExerciseItemController {

    private final ExerciseItemService exerciseItemService;

    public ExerciseItemController(ExerciseItemService exerciseItemService) {
        this.exerciseItemService = exerciseItemService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseItemResponseDTO>> getAll() {
        return ResponseEntity.ok().body(exerciseItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseItemResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(exerciseItemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ExerciseItemResponseDTO> create(ExerciseItemRequestDTO exerciseItem) {
        return ResponseEntity.ok().body(exerciseItemService.create(exerciseItem));
    }

    @PutMapping
    public ResponseEntity<ExerciseItemResponseDTO> update(ExerciseItemRequestDTO exerciseItem) {
        return ResponseEntity.ok().body(exerciseItemService.update(exerciseItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        exerciseItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}