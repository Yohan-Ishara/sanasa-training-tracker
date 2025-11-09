package com.sanasa.trainingtracker.repository;


import com.sanasa.trainingtracker.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByRole_RoleName(String roleName);
}

