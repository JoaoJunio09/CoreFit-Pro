package br.com.joaojuniodev.corefitpro.muscleGroup.controller;

import br.com.joaojuniodev.corefitpro.muscleGroup.dto.request.MuscleGroupRequestDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.dto.response.MuscleGroupResponseDTO;
import br.com.joaojuniodev.corefitpro.muscleGroup.service.MuscleGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/muscleGroups/v1")
public class MuscleGroupController {

    private final MuscleGroupService muscleGroupService;

    public MuscleGroupController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }

    @GetMapping
    public ResponseEntity<List<MuscleGroupResponseDTO>> getAll() {
        return ResponseEntity.ok().body(muscleGroupService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuscleGroupResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(muscleGroupService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MuscleGroupResponseDTO> create(@RequestBody MuscleGroupRequestDTO muscleGroup) {
        return ResponseEntity.ok().body(muscleGroupService.create(muscleGroup));
    }

    @PutMapping
    public ResponseEntity<MuscleGroupResponseDTO> update(@RequestBody MuscleGroupRequestDTO muscleGroup) {
        return ResponseEntity.ok().body(muscleGroupService.update(muscleGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        muscleGroupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}