package com.sanasa.trainingtracker.repository;

import com.sanasa.trainingtracker.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStaff_Id(Long staffId);
    List<Attendance> findByStatus(String status);

    List<Attendance> findByTraining_Id(Long trainingId);
}
