package br.com.joaojuniodev.corefitpro.exercise.service;

import br.com.joaojuniodev.corefitpro.exceptions.NotFoundException;
import br.com.joaojuniodev.corefitpro.exercise.dto.request.ExerciseRequestDTO;
import br.com.joaojuniodev.corefitpro.exercise.dto.response.ExerciseResponseDTO;
import br.com.joaojuniodev.corefitpro.exercise.repository.ExerciseRepository;
import br.com.joaojuniodev.corefitpro.exercise.repository.spec.ExerciseSpecification;
import br.com.joaojuniodev.corefitpro.infrastructure.backblaze.B2StorageGateway;
import br.com.joaojuniodev.corefitpro.infrastructure.backblaze.dto.StoredFileResponse;
import br.com.joaojuniodev.corefitpro.mapper.exercise.ExerciseMapper;
import br.com.joaojuniodev.corefitpro.muscleGroup.model.MuscleGroup;
import br.com.joaojuniodev.corefitpro.muscleGroup.repository.MuscleGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class ExerciseService {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseService.class.getName());

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper mapper;
    private final B2StorageGateway b2Storage;
    private final MuscleGroupRepository muscleGroupRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseMapper mapper, B2StorageGateway b2Storage, MuscleGroupRepository muscleGroupRepository) {
        this.exerciseRepository = exerciseRepository;
        this.mapper = mapper;
        this.b2Storage = b2Storage;
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public List<ExerciseResponseDTO> getAll(UUID personalTrainerId) {
        logger.info("Getting All Exercises");

        ExerciseSpecification spec = new ExerciseSpecification();
        spec.addToSpecifications(personalTrainerId);

        return exerciseRepository
            .findAll(spec.apply())
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    public ExerciseResponseDTO getById(UUID id) {
        logger.info("Getting By Exercise Id");

        var entity = exerciseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        return mapper.toResponse(entity);
    }

    public StoredFileResponse addFile(UUID exerciseId, MultipartFile file, String folder) {
        logger.info("Adding video/image for Exercise");

        var entity = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + exerciseId));

        var storedResponse = b2Storage.upload(file, folder);

        if (b2Storage.isImage(file)) {
            entity.setPhotoFileId(storedResponse.fileId());
            entity.setPhotoKey(storedResponse.fileKey());
        } else {
            entity.setVideoKey(storedResponse.fileKey());
            entity.setVideoFileId(storedResponse.fileId());
        }
        exerciseRepository.save(entity);

        return storedResponse;
    }

    public ExerciseResponseDTO create(ExerciseRequestDTO exercise, MultipartFile photo) {
        logger.info("Creating new Exercise");

        var entity = mapper.toEntity(exercise);
        entity.setSystem(false);

        List<MuscleGroup> muscleGroups = muscleGroupRepository.findAllById(exercise.muscleGroupsId());
        entity.setMuscleGroups(new HashSet<>(muscleGroups));

        if (photo != null) {
            var storedResponse = b2Storage.upload(photo, "exercises/images");

            entity.setPhotoFileId(storedResponse.fileId());
            entity.setPhotoKey( storedResponse.fileKey());
        }

        var exerciseCreated = exerciseRepository.save(entity);
        return mapper.toResponse(exerciseCreated);
    }

    public ExerciseResponseDTO update(ExerciseRequestDTO exercise, MultipartFile photo) {
        logger.info("Updating Exercise");

        var entity = exerciseRepository.findById(exercise.id())
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + exercise.id()));

        if (Boolean.TRUE.equals(entity.getSystem()))
            throw new IllegalArgumentException("This exercise belongs to the system; it cannot be changed.");

        entity.setName(exercise.name());

        List<MuscleGroup> muscleGroups = muscleGroupRepository.findAllById(exercise.muscleGroupsId());
        entity.setMuscleGroups(new HashSet<>(muscleGroups));

        if (photo != null) {
            var storedResponse = b2Storage.upload(photo, "exercises/images");

            entity.setPhotoFileId(storedResponse.fileId());
            entity.setPhotoKey( storedResponse.fileKey());
        }

        var exerciseUpdated = exerciseRepository.save(entity);
        return mapper.toResponse(exerciseUpdated);
    }

    public ExerciseResponseDTO toggleFavorite(UUID id, Boolean favorite) {
        logger.info("Updating favorite Exercise by Id");

        var entity = exerciseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));

        if (!entity.getSystem()) {
            entity.setFavorite(Boolean.TRUE.equals(favorite));
        }

        return mapper.toResponse(entity);
    }

    public void delete(UUID id) {
        logger.info("Deleting Exercise");

        var entity = exerciseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Not found this Exercise Id: " + id));
        exerciseRepository.delete(entity);
    }
}
