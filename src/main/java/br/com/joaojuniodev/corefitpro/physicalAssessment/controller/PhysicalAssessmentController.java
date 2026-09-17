package br.com.joaojuniodev.corefitpro.physicalAssessment.controller;

import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.request.PhysicalAssessmentRequestDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.dto.response.PhysicalAssessmentResponseDTO;
import br.com.joaojuniodev.corefitpro.physicalAssessment.service.PhysicalAssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/physicalAssessments/v1")
public class PhysicalAssessmentController {

    private final PhysicalAssessmentService physicalAssessmentService;

    public PhysicalAssessmentController(PhysicalAssessmentService physicalAssessmentService) {
        this.physicalAssessmentService = physicalAssessmentService;
    }

    @GetMapping
    public ResponseEntity<List<PhysicalAssessmentResponseDTO>> getAll(
        @RequestParam(name = "traineeId", required = false) UUID traineeId
    ) {
        return ResponseEntity.ok().body(physicalAssessmentService.getAll(traineeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysicalAssessmentResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(physicalAssessmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PhysicalAssessmentResponseDTO> create(@RequestBody PhysicalAssessmentRequestDTO physicalAssessment) {
        return ResponseEntity.ok().body(physicalAssessmentService.create(physicalAssessment));
    }

    @PutMapping
    public ResponseEntity<PhysicalAssessmentResponseDTO> update(@RequestBody PhysicalAssessmentRequestDTO physicalAssessment) {
        return ResponseEntity.ok().body(physicalAssessmentService.update(physicalAssessment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        physicalAssessmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}