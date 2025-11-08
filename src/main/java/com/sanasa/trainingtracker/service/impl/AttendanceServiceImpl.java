package com.sanasa.trainingtracker.service.impl;
import com.sanasa.trainingtracker.entities.Attendance;
import com.sanasa.trainingtracker.repository.AttendanceRepository;
import com.sanasa.trainingtracker.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    @Override
    public List<Attendance> getAttendanceByTraining(Long trainingId) {
        return attendanceRepository.findByTrainingProgram_Id(trainingId);
    }

    @Override
    public List<Attendance> getAttendanceByStaff(Long staffId) {
        return attendanceRepository.findByStaff_Id(staffId);
    }

    @Override
    public List<Attendance> getAttendanceByStatus(String status) {
        return attendanceRepository.findByStatus(status);
    }
}
