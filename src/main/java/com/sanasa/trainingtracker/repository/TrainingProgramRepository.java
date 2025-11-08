package com.sanasa.trainingtracker.repository;

import com.sanasa.trainingtracker.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingProgramRepository extends JpaRepository<Training, Long> {
}
