package com.sanasa.trainingtracker.service;

import com.sanasa.trainingtracker.entities.Training;

import java.util.List;

public interface TrainingProgramService {
    Training saveTraining(Training training);
    List<Training> getAllTrainings();
    Training getTrainingById(Long id);
    void deleteTraining(Long id);
}
