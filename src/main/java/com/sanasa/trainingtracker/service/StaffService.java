package com.sanasa.trainingtracker.service;

import com.sanasa.trainingtracker.entities.Staff;
import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);
    Staff getStaffById(Long id);
    List<Staff> getAllStaff();
    void deleteStaff(Long id);
    List<Staff> getStaffByRole(String roleName);
}
