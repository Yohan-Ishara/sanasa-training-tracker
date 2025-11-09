package com.sanasa.trainingtracker.controllers;

import com.sanasa.trainingtracker.entities.Training;
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
    public Training create(@RequestBody Training training) {
        return trainingService.saveTraining(training);
    }

    @GetMapping
    public List<Training> getAll() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public Training getById(@PathVariable Long id) {
        return trainingService.getTrainingById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
    }
}
