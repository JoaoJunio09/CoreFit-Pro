package br.com.joaojuniodev.corefitpro.trainingItem.controller;

import br.com.joaojuniodev.corefitpro.trainingItem.dto.request.TrainingItemRequestDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.dto.response.TrainingItemResponseDTO;
import br.com.joaojuniodev.corefitpro.trainingItem.service.TrainingItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trainingItems/v1")
public class TrainingItemController {

    private final TrainingItemService trainingService;

    public TrainingItemController(TrainingItemService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingItemResponseDTO>> getAll() {
        return ResponseEntity.ok().body(trainingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingItemResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(trainingService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TrainingItemResponseDTO> create(@RequestBody TrainingItemRequestDTO trainingItem) {
        return ResponseEntity.ok().body(trainingService.create(trainingItem));
    }

    @PutMapping
    public ResponseEntity<TrainingItemResponseDTO> update(@RequestBody TrainingItemRequestDTO trainingItem) {
        return ResponseEntity.ok().body(trainingService.update(trainingItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        trainingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}