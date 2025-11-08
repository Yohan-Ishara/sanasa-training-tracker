package com.sanasa.trainingtracker.controller;

import com.sanasa.trainingtracker.entities.TrainingProgram;
import com.sanasa.trainingtracker.service.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
@CrossOrigin
public class TrainingProgramController {

    private final TrainingProgramService trainingService;

    @PostMapping
    public TrainingProgram create(@RequestBody TrainingProgram training) {
        return trainingService.saveTraining(training);
    }

    @GetMapping
    public List<TrainingProgram> getAll() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public TrainingProgram getById(@PathVariable Long id) {
        return trainingService.getTrainingById(id);
    }

    @GetMapping("/type/{type}")
    public List<TrainingProgram> getByType(@PathVariable String type) {
        return trainingService.getTrainingsByType(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
    }
}
