package com.sanasa.trainingtracker.service;

import com.sanasa.trainingtracker.entities.Attendance;

import java.util.List;

public interface    AttendanceService {
    Attendance saveAttendance(Attendance attendance);
    List<Attendance> getAttendanceByTraining(Long trainingId);
    List<Attendance> getAttendanceByStaff(Long staffId);
    List<Attendance> getAttendanceByStatus(String status);
}
