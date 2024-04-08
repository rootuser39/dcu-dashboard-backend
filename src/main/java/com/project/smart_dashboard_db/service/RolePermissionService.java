package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.RolePermission;
import com.project.smart_dashboard_db.repository.RolePermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    public List<RolePermission> getAllRolePermissions() {
        return rolePermissionRepository.findAll();
    }

    public RolePermission createRolePermission(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    public RolePermission getRolePermissionById(Long id) {
        Optional<RolePermission> rolePermissionOptional = rolePermissionRepository.findById(id);
        return rolePermissionOptional.orElse(null);
    }

    public RolePermission updateRolePermission(Long id, RolePermission rolePermissionDetails) {
        Optional<RolePermission> optionalRolePermission = rolePermissionRepository.findById(id);
        if (optionalRolePermission.isPresent()) {
            RolePermission existingRolePermission = optionalRolePermission.get();
            existingRolePermission.setRole(rolePermissionDetails.getRole());
            return rolePermissionRepository.save(existingRolePermission);
        }
        return null;
    }

    public boolean deleteRolePermission(Long id) {
        Optional<RolePermission> optionalRolePermission = rolePermissionRepository.findById(id);
        if (optionalRolePermission.isPresent()) {
            rolePermissionRepository.delete(optionalRolePermission.get());
            return true;
        }
        return false;
    }
}