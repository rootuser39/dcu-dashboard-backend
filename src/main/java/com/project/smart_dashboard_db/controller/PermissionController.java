package com.project.smart_dashboard_db.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.smart_dashboard_db.model.Permission;
import com.project.smart_dashboard_db.service.PermissionService;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        List<Permission> permissions = permissionService.getAllPermissions();
        return ResponseEntity.ok(permissions);
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        Permission createdPermission = permissionService.createPermission(permission);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPermission);
    }

    @GetMapping("/getById")
    public ResponseEntity<Permission> getPermissionById(@RequestParam Long id) {
        Permission permission = permissionService.getPermissionById(id);
        if (permission != null) {
            return ResponseEntity.ok(permission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Permission> updatePermission(@RequestParam Long id, @RequestBody Permission permissionDetails) {
        Permission updatedPermission = permissionService.updatePermission(id, permissionDetails);
        if (updatedPermission != null) {
            return ResponseEntity.ok(updatedPermission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePermission(@RequestParam Long id) {
        boolean deleted = permissionService.deletePermission(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}