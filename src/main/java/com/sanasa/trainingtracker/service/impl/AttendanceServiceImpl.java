package com.sanasa.trainingtracker.service.impl;
import com.sanasa.trainingtracker.entities.Attendance;
import com.sanasa.trainingtracker.entities.Staff;
import com.sanasa.trainingtracker.entities.Training;
import com.sanasa.trainingtracker.repository.AttendanceRepository;
import com.sanasa.trainingtracker.repository.StaffRepository;
import com.sanasa.trainingtracker.repository.TrainingProgramRepository;
import com.sanasa.trainingtracker.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final TrainingProgramRepository trainingRepository;
    private final StaffRepository staffRepository;

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    @Override
    public List<Attendance> getAttendanceByTraining(Long trainingId) {
        return attendanceRepository.findByTraining_Id(trainingId);
    }

    @Override
    public List<Attendance> getAttendanceByStaff(Long staffId) {
        return attendanceRepository.findByStaff_Id(staffId);
    }

    @Override
    public List<Attendance> getAttendanceByStatus(String status) {
        return attendanceRepository.findByStatus(status);
    }

    @Override
    public List<Attendance> assignParticipants(Long trainingId, List<Long> staffIds) {
        Training training = trainingRepository.findById(trainingId).orElseThrow();
        List<Attendance> records = new ArrayList<>();

        for (Long staffId : staffIds) {
            Staff staff = staffRepository.findById(staffId).orElseThrow();

            // Prevent duplicate entries
            if (!attendanceRepository.existsByStaffAndTraining(staff, training)) {
                Attendance attendance = Attendance.builder()
                        .staff(staff)
                        .training(training)
                        .status("Assigned")
                        .build();
                records.add(attendanceRepository.save(attendance));
            }
        }
        return records;
    }

    @Override
    public Attendance updateAttendeeStatus(Long id, String status) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow();
        attendance.setStatus(status);
        attendanceRepository.save(attendance);
        return attendance;
    }
}
