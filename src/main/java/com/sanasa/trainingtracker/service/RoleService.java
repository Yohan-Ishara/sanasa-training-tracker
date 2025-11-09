package com.sanasa.trainingtracker.service;

import com.sanasa.trainingtracker.entities.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role createRole(Role role);

    void deleteRole(Long id);
}
