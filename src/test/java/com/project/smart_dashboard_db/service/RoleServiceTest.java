package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.Role;
import com.project.smart_dashboard_db.repository.RoleRepository;
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
class RoleServiceTest {

	@Mock
	private RoleRepository roleRepository;

	@InjectMocks
	private RoleService roleService;

	@Test
	void testGetAllRoles() {
		// Create mock roles
		List<Role> mockRoles = Arrays.asList(new Role(), new Role());
		// Mock the behavior of roleRepository.findAll()
		when(roleRepository.findAll()).thenReturn(mockRoles);

		// Call the service method
		List<Role> result = roleService.getAllRoles();

		// Verify the result
		assertEquals(mockRoles, result);
	}

	@Test
	void testCreateRole() {
		// Create a mock role
		Role mockRole = new Role();
		// Mock the behavior of roleRepository.save()
		when(roleRepository.save(mockRole)).thenReturn(mockRole);

		// Call the service method
		Role result = roleService.createRole(mockRole);

		// Verify the result
		assertEquals(mockRole, result);
	}

	@Test
	void testGetRoleById_PositiveScenario() {
		// Create a mock role
		Role mockRole = new Role();
		// Mock the behavior of roleRepository.findById()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.of(mockRole));

		// Call the service method
		Role result = roleService.getRoleById(1L);

		// Verify the result
		assertEquals(mockRole, result);
	}

	@Test
	void testGetRoleById_NegativeScenario() {
		// Mock the behavior of roleRepository.findById() to return Optional.empty()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Role result = roleService.getRoleById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateRole_PositiveScenario() {
		// Create a mock role
		Role mockRole = new Role();
		// Mock the behavior of roleRepository.findById()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.of(mockRole));
		// Mock the behavior of roleRepository.save()
		when(roleRepository.save(mockRole)).thenReturn(mockRole);

		// Call the service method
		Role result = roleService.updateRole(1L, mockRole);

		// Verify the result
		assertEquals(mockRole, result);
	}

	@Test
	void testUpdateRole_NegativeScenario() {
		// Mock the behavior of roleRepository.findById() to return Optional.empty()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Role result = roleService.updateRole(1L, new Role());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteRole_PositiveScenario() {
		// Mock the behavior of roleRepository.findById()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.of(new Role()));

		// Call the service method
		boolean result = roleService.deleteRole(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteRole_NegativeScenario() {
		// Mock the behavior of roleRepository.findById() to return Optional.empty()
		when(roleRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = roleService.deleteRole(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
