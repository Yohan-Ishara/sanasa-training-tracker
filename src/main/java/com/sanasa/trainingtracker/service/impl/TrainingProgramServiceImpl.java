package com.sanasa.trainingtracker.service.impl;


import com.sanasa.trainingtracker.entities.TrainingProgram;
import com.sanasa.trainingtracker.repository.TrainingProgramRepository;
import com.sanasa.trainingtracker.service.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepository trainingRepository;

    @Override
    public TrainingProgram saveTraining(TrainingProgram training) {
        return trainingRepository.save(training);
    }

    @Override
    public List<TrainingProgram> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public TrainingProgram getTrainingById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public List<TrainingProgram> getTrainingsByType(String type) {
        return trainingRepository.findByTrainingType(type);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}
