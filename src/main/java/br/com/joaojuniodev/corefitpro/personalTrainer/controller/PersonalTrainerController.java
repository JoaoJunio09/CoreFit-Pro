package br.com.joaojuniodev.corefitpro.personalTrainer.controller;

import br.com.joaojuniodev.corefitpro.personalTrainer.dto.request.PersonalTrainerRequestDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.DashboardResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.dto.response.PersonalTrainerResponseDTO;
import br.com.joaojuniodev.corefitpro.personalTrainer.service.PersonalDashboardService;
import br.com.joaojuniodev.corefitpro.personalTrainer.service.PersonalTrainerService;
import br.com.joaojuniodev.corefitpro.trainee.dto.response.TraineeDetailsDTO;
import br.com.joaojuniodev.corefitpro.trainee.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personalTrainers/v1")
public class PersonalTrainerController {

    private final PersonalTrainerService personalTrainerService;
    private final PersonalDashboardService personalDashboardService;
    private final TraineeService traineeService;

    public PersonalTrainerController(PersonalTrainerService personalTrainerService, PersonalDashboardService personalDashboardService, TraineeService traineeService) {
        this.personalTrainerService = personalTrainerService;
        this.personalDashboardService = personalDashboardService;
        this.traineeService = traineeService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalTrainerResponseDTO>> getAll() {
        return ResponseEntity.ok().body(personalTrainerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalTrainerResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personalTrainerService.getById(id));
    }

    @GetMapping("/dashboard/{id}")
    public ResponseEntity<DashboardResponseDTO> getDashboard(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personalDashboardService.getDashboard(id));
    }

    @GetMapping("/trainees/{id}")
    public ResponseEntity<List<TraineeDetailsDTO>> getTrainees(@PathVariable UUID id) {
        return ResponseEntity.ok().body(traineeService.getAllByPersonal(id));
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