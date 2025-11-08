package com.sanasa.trainingtracker.service;

import com.sanasa.trainingtracker.entities.TrainingProgram;

import java.util.List;

public interface TrainingProgramService {
    TrainingProgram saveTraining(TrainingProgram training);
    List<TrainingProgram> getAllTrainings();
    TrainingProgram getTrainingById(Long id);
    List<TrainingProgram> getTrainingsByType(String type);
    void deleteTraining(Long id);
}
