package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Permission;
import com.project.smart_dashboard_db.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission getPermissionById(Long id) {
        Optional<Permission> permissionOptional = permissionRepository.findById(id);
        return permissionOptional.orElse(null);
    }

    public Permission updatePermission(Long id, Permission permissionDetails) {
        Optional<Permission> optionalPermission = permissionRepository.findById(id);
        if (optionalPermission.isPresent()) {
            Permission existingPermission = optionalPermission.get();
            existingPermission.setTitle(permissionDetails.getTitle());
            existingPermission.setDescription(permissionDetails.getDescription());
            return permissionRepository.save(existingPermission);
        }
        return null;
    }

    public boolean deletePermission(Long id) {
        Optional<Permission> optionalPermission = permissionRepository.findById(id);
        if (optionalPermission.isPresent()) {
            permissionRepository.delete(optionalPermission.get());
            return true;
        }
        return false;
    }
}