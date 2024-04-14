package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.RoomSlot;
import com.project.smart_dashboard_db.repository.RoomSlotRepository;
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
class RoomSlotServiceTest {

	@Mock
	private RoomSlotRepository roomSlotRepository;

	@InjectMocks
	private RoomSlotService roomSlotService;

	@Test
	void testGetAllRoomSlots() {
		// Create mock room slots
		List<RoomSlot> mockRoomSlots = Arrays.asList(new RoomSlot(), new RoomSlot());
		// Mock the behavior of roomSlotRepository.findAll()
		when(roomSlotRepository.findAll()).thenReturn(mockRoomSlots);

		// Call the service method
		List<RoomSlot> result = roomSlotService.getAllRoomSlots();

		// Verify the result
		assertEquals(mockRoomSlots, result);
	}

	@Test
	void testCreateRoomSlot() {
		// Create a mock room slot
		RoomSlot mockRoomSlot = new RoomSlot();
		// Mock the behavior of roomSlotRepository.save()
		when(roomSlotRepository.save(mockRoomSlot)).thenReturn(mockRoomSlot);

		// Call the service method
		RoomSlot result = roomSlotService.createRoomSlot(mockRoomSlot);

		// Verify the result
		assertEquals(mockRoomSlot, result);
	}

	@Test
	void testGetRoomSlotById_PositiveScenario() {
		// Create a mock room slot
		RoomSlot mockRoomSlot = new RoomSlot();
		// Mock the behavior of roomSlotRepository.findById()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.of(mockRoomSlot));

		// Call the service method
		RoomSlot result = roomSlotService.getRoomSlotById(1L);

		// Verify the result
		assertEquals(mockRoomSlot, result);
	}

	@Test
	void testGetRoomSlotById_NegativeScenario() {
		// Mock the behavior of roomSlotRepository.findById() to return Optional.empty()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		RoomSlot result = roomSlotService.getRoomSlotById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateRoomSlot_PositiveScenario() {
		// Create a mock room slot
		RoomSlot mockRoomSlot = new RoomSlot();
		// Mock the behavior of roomSlotRepository.findById()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.of(mockRoomSlot));
		// Mock the behavior of roomSlotRepository.save()
		when(roomSlotRepository.save(mockRoomSlot)).thenReturn(mockRoomSlot);

		// Call the service method
		RoomSlot result = roomSlotService.updateRoomSlot(1L, mockRoomSlot);

		// Verify the result
		assertEquals(mockRoomSlot, result);
	}

	@Test
	void testUpdateRoomSlot_NegativeScenario() {
		// Mock the behavior of roomSlotRepository.findById() to return Optional.empty()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		RoomSlot result = roomSlotService.updateRoomSlot(1L, new RoomSlot());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteRoomSlot_PositiveScenario() {
		// Mock the behavior of roomSlotRepository.findById()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.of(new RoomSlot()));

		// Call the service method
		boolean result = roomSlotService.deleteRoomSlot(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteRoomSlot_NegativeScenario() {
		// Mock the behavior of roomSlotRepository.findById() to return Optional.empty()
		when(roomSlotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = roomSlotService.deleteRoomSlot(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
