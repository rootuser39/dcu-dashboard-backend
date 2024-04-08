package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Role;
import com.project.smart_dashboard_db.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElse(null);
    }

    public Role updateRole(Long id, Role roleDetails) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setTitle(roleDetails.getTitle());
            existingRole.setDescription(roleDetails.getDescription());
            return roleRepository.save(existingRole);
        }
        return null;
    }

    public boolean deleteRole(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            roleRepository.delete(optionalRole.get());
            return true;
        }
        return false;
    }
}