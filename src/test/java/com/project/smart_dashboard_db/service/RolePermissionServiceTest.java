package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.RolePermission;
import com.project.smart_dashboard_db.repository.RolePermissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RolePermissionServiceTest {

	@Mock
	private RolePermissionRepository rolePermissionRepository;

	@InjectMocks
	private RolePermissionService rolePermissionService;

	@Test
	void testGetAllRolePermissions() {
		// Create mock role permissions
		List<RolePermission> mockRolePermissions = Arrays.asList(new RolePermission(), new RolePermission());
		// Mock the behavior of rolePermissionRepository.findAll()
		when(rolePermissionRepository.findAll()).thenReturn(mockRolePermissions);

		// Call the service method
		List<RolePermission> result = rolePermissionService.getAllRolePermissions();

		// Verify the result
		assertEquals(mockRolePermissions, result);
	}

	@Test
	void testCreateRolePermission() {
		// Create a mock role permission
		RolePermission mockRolePermission = new RolePermission();
		// Mock the behavior of rolePermissionRepository.save()
		when(rolePermissionRepository.save(mockRolePermission)).thenReturn(mockRolePermission);

		// Call the service method
		RolePermission result = rolePermissionService.createRolePermission(mockRolePermission);

		// Verify the result
		assertEquals(mockRolePermission, result);
	}

	@Test
	void testGetRolePermissionById_PositiveScenario() {
		// Create a mock role permission
		RolePermission mockRolePermission = new RolePermission();
		// Mock the behavior of rolePermissionRepository.findById()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.of(mockRolePermission));

		// Call the service method
		RolePermission result = rolePermissionService.getRolePermissionById(1L);

		// Verify the result
		assertEquals(mockRolePermission, result);
	}

	@Test
	void testGetRolePermissionById_NegativeScenario() {
		// Mock the behavior of rolePermissionRepository.findById() to return
		// Optional.empty()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		RolePermission result = rolePermissionService.getRolePermissionById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateRolePermission_PositiveScenario() {
		// Create a mock role permission
		RolePermission mockRolePermission = new RolePermission();
		// Mock the behavior of rolePermissionRepository.findById()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.of(mockRolePermission));
		// Mock the behavior of rolePermissionRepository.save()
		when(rolePermissionRepository.save(mockRolePermission)).thenReturn(mockRolePermission);

		// Call the service method
		RolePermission result = rolePermissionService.updateRolePermission(1L, mockRolePermission);

		// Verify the result
		assertEquals(mockRolePermission, result);
	}

	@Test
	void testUpdateRolePermission_NegativeScenario() {
		// Mock the behavior of rolePermissionRepository.findById() to return
		// Optional.empty()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		RolePermission result = rolePermissionService.updateRolePermission(1L, new RolePermission());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteRolePermission_PositiveScenario() {
		// Mock the behavior of rolePermissionRepository.findById()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.of(new RolePermission()));

		// Call the service method
		boolean result = rolePermissionService.deleteRolePermission(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteRolePermission_NegativeScenario() {
		// Mock the behavior of rolePermissionRepository.findById() to return
		// Optional.empty()
		when(rolePermissionRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = rolePermissionService.deleteRolePermission(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
