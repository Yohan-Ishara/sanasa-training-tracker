package com.sanasa.trainingtracker.service.impl;

import com.sanasa.trainingtracker.entities.Staff;
import com.sanasa.trainingtracker.repository.StaffRepository;
import com.sanasa.trainingtracker.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public List<Staff> getStaffByRole(String roleName) {
        return staffRepository.findByRole_RoleName(roleName);
    }
}
