package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.User;
import com.project.smart_dashboard_db.repository.UserRepository;
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
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	void testGetAllUsers() {
		// Create mock users
		List<User> mockUsers = Arrays.asList(new User(), new User());
		// Mock the behavior of userRepository.findAll()
		when(userRepository.findAll()).thenReturn(mockUsers);

		// Call the service method
		List<User> result = userService.getAllUsers();

		// Verify the result
		assertEquals(mockUsers, result);
	}

	@Test
	void testCreateUser() {
		// Create a mock user
		User mockUser = new User();
		// Mock the behavior of userRepository.save()
		when(userRepository.save(mockUser)).thenReturn(mockUser);

		// Call the service method
		User result = userService.createUser(mockUser);

		// Verify the result
		assertEquals(mockUser, result);
	}

	@Test
	void testGetUserById_PositiveScenario() {
		// Create a mock user
		User mockUser = new User();
		// Mock the behavior of userRepository.findById()
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(mockUser));

		// Call the service method
		User result = userService.getUserById(1L);

		// Verify the result
		assertEquals(mockUser, result);
	}

	@Test
	void testGetUserById_NegativeScenario() {
		// Mock the behavior of userRepository.findById() to return Optional.empty()
		when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		User result = userService.getUserById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateUser_PositiveScenario() {
		// Create a mock user
		User mockUser = new User();
		// Mock the behavior of userRepository.findById()
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(mockUser));
		// Mock the behavior of userRepository.save()
		when(userRepository.save(mockUser)).thenReturn(mockUser);

		// Call the service method
		User result = userService.updateUser(1L, mockUser);

		// Verify the result
		assertEquals(mockUser, result);
	}

	@Test
	void testUpdateUser_NegativeScenario() {
		// Mock the behavior of userRepository.findById() to return Optional.empty()
		when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		User result = userService.updateUser(1L, new User());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteUser_PositiveScenario() {
		// Mock the behavior of userRepository.findById()
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));

		// Call the service method
		boolean result = userService.deleteUser(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteUser_NegativeScenario() {
		// Mock the behavior of userRepository.findById() to return Optional.empty()
		when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = userService.deleteUser(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
