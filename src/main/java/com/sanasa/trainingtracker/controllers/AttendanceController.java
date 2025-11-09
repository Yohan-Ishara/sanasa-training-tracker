package com.sanasa.trainingtracker.controllers;

import com.sanasa.trainingtracker.entities.Attendance;
import com.sanasa.trainingtracker.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
@CrossOrigin
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping
    public Attendance create(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @PostMapping("/assign/{trainingId}")
    public ResponseEntity<List<Attendance>> assignParticipants(
            @PathVariable Long trainingId,
            @RequestBody List<Long> staffIds) {

        List<Attendance> records = attendanceService.assignParticipants(trainingId,staffIds);
        return ResponseEntity.ok(records);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Attendance> updateStatus(@PathVariable Long id,
                                                   @RequestParam String status) {

        Attendance attendance = attendanceService.updateAttendeeStatus(id,status);
        return ResponseEntity.ok(attendance);
    }


    @GetMapping("/training/{trainingId}")
    public List<Attendance> getByTraining(@PathVariable Long trainingId) {
        return attendanceService.getAttendanceByTraining(trainingId);
    }

    @GetMapping("/staff/{staffId}")
    public List<Attendance> getByStaff(@PathVariable Long staffId) {
        return attendanceService.getAttendanceByStaff(staffId);
    }

    @GetMapping("/status/{status}")
    public List<Attendance> getByStatus(@PathVariable String status) {
        return attendanceService.getAttendanceByStatus(status);
    }
}
