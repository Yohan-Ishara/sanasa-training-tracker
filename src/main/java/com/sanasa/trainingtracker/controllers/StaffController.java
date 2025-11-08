package com.sanasa.trainingtracker.controllers;

import com.sanasa.trainingtracker.entities.Staff;
import com.sanasa.trainingtracker.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
@CrossOrigin
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @GetMapping
    public List<Staff> getAll() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @GetMapping("/role/{roleName}")
    public List<Staff> getByRole(@PathVariable String roleName) {
        return staffService.getStaffByRole(roleName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
