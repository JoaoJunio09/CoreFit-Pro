package br.com.joaojuniodev.corefitpro.trainee.controller;

import br.com.joaojuniodev.corefitpro.trainee.dto.request.TraineeRequestDTO;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeResponseDTO;
import br.com.joaojuniodev.corefitpro.trainee.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trainees/v1")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    public ResponseEntity<List<TraineeResponseDTO>> getAll() {
        return ResponseEntity.ok().body(traineeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraineeResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(traineeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TraineeResponseDTO> create(@RequestBody TraineeRequestDTO trainee) {
        return ResponseEntity.ok().body(traineeService.create(trainee));
    }

    @PutMapping
    public ResponseEntity<TraineeResponseDTO> update(@RequestBody TraineeRequestDTO trainee) {
        return ResponseEntity.ok().body(traineeService.update(trainee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        traineeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}