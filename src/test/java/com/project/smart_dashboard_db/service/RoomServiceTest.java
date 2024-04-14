package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.Room;
import com.project.smart_dashboard_db.repository.RoomRepository;
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
class RoomServiceTest {

	@Mock
	private RoomRepository roomRepository;

	@InjectMocks
	private RoomService roomService;

	@Test
	void testGetAllRooms() {
		// Create mock rooms
		List<Room> mockRooms = Arrays.asList(new Room(), new Room());
		// Mock the behavior of roomRepository.findAll()
		when(roomRepository.findAll()).thenReturn(mockRooms);

		// Call the service method
		List<Room> result = roomService.getAllRooms();

		// Verify the result
		assertEquals(mockRooms, result);
	}

	@Test
	void testCreateRoom() {
		// Create a mock room
		Room mockRoom = new Room();
		// Mock the behavior of roomRepository.save()
		when(roomRepository.save(mockRoom)).thenReturn(mockRoom);

		// Call the service method
		Room result = roomService.createRoom(mockRoom);

		// Verify the result
		assertEquals(mockRoom, result);
	}

	@Test
	void testGetRoomById_PositiveScenario() {
		// Create a mock room
		Room mockRoom = new Room();
		// Mock the behavior of roomRepository.findById()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.of(mockRoom));

		// Call the service method
		Room result = roomService.getRoomById(1L);

		// Verify the result
		assertEquals(mockRoom, result);
	}

	@Test
	void testGetRoomById_NegativeScenario() {
		// Mock the behavior of roomRepository.findById() to return Optional.empty()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Room result = roomService.getRoomById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateRoom_PositiveScenario() {
		// Create a mock room
		Room mockRoom = new Room();
		// Mock the behavior of roomRepository.findById()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.of(mockRoom));
		// Mock the behavior of roomRepository.save()
		when(roomRepository.save(mockRoom)).thenReturn(mockRoom);

		// Call the service method
		Room result = roomService.updateRoom(1L, mockRoom);

		// Verify the result
		assertEquals(mockRoom, result);
	}

	@Test
	void testUpdateRoom_NegativeScenario() {
		// Mock the behavior of roomRepository.findById() to return Optional.empty()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Room result = roomService.updateRoom(1L, new Room());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteRoom_PositiveScenario() {
		// Mock the behavior of roomRepository.findById()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.of(new Room()));

		// Call the service method
		boolean result = roomService.deleteRoom(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteRoom_NegativeScenario() {
		// Mock the behavior of roomRepository.findById() to return Optional.empty()
		when(roomRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = roomService.deleteRoom(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
