package com.sanasa.trainingtracker.service.impl;


import com.sanasa.trainingtracker.entities.Training;
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
    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}
