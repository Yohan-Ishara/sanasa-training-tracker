package com.sanasa.trainingtracker.service.impl;

import com.sanasa.trainingtracker.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.sanasa.trainingtracker.entities.Role;
import com.sanasa.trainingtracker.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl  implements RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

}
