package com.project.smart_dashboard_db.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.smart_dashboard_db.model.Permission;
import com.project.smart_dashboard_db.repository.PermissionRepository;

@ExtendWith(MockitoExtension.class)
public class PermissionServiceTest {

    @Mock
    private PermissionRepository permissionRepository;

    @InjectMocks
    private PermissionService permissionService;

    @Test
    void testGetAllPermissions() {
        // Create mock permissions
        List<Permission> mockPermissions = Arrays.asList(new Permission(), new Permission());
        // Mock the behavior of permissionRepository.findAll()
        when(permissionRepository.findAll()).thenReturn(mockPermissions);

        // Call the service method
        List<Permission> result = permissionService.getAllPermissions();

        // Verify the result
        assertEquals(mockPermissions, result);
    }

    @Test
    void testCreatePermission() {
        // Create a mock permission
        Permission mockPermission = new Permission();
        // Mock the behavior of permissionRepository.save()
        when(permissionRepository.save(mockPermission)).thenReturn(mockPermission);

        // Call the service method
        Permission result = permissionService.createPermission(mockPermission);

        // Verify the result
        assertEquals(mockPermission, result);
    }

    // Add tests for other methods (getPermissionById, updatePermission, deletePermission) similarly
}
