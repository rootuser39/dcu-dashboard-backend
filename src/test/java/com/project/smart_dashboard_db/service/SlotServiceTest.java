package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.Slot;
import com.project.smart_dashboard_db.repository.SlotRepository;
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
class SlotServiceTest {

	@Mock
	private SlotRepository slotRepository;

	@InjectMocks
	private SlotService slotService;

	@Test
	void testGetAllSlots() {
		// Create mock slots
		List<Slot> mockSlots = Arrays.asList(new Slot(), new Slot());
		// Mock the behavior of slotRepository.findAll()
		when(slotRepository.findAll()).thenReturn(mockSlots);

		// Call the service method
		List<Slot> result = slotService.getAllSlots();

		// Verify the result
		assertEquals(mockSlots, result);
	}

	@Test
	void testCreateSlot() {
		// Create a mock slot
		Slot mockSlot = new Slot();
		// Mock the behavior of slotRepository.save()
		when(slotRepository.save(mockSlot)).thenReturn(mockSlot);

		// Call the service method
		Slot result = slotService.createSlot(mockSlot);

		// Verify the result
		assertEquals(mockSlot, result);
	}

	@Test
	void testGetSlotById_PositiveScenario() {
		// Create a mock slot
		Slot mockSlot = new Slot();
		// Mock the behavior of slotRepository.findById()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.of(mockSlot));

		// Call the service method
		Slot result = slotService.getSlotById(1L);

		// Verify the result
		assertEquals(mockSlot, result);
	}

	@Test
	void testGetSlotById_NegativeScenario() {
		// Mock the behavior of slotRepository.findById() to return Optional.empty()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Slot result = slotService.getSlotById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateSlot_PositiveScenario() {
		// Create a mock slot
		Slot mockSlot = new Slot();
		// Mock the behavior of slotRepository.findById()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.of(mockSlot));
		// Mock the behavior of slotRepository.save()
		when(slotRepository.save(mockSlot)).thenReturn(mockSlot);

		// Call the service method
		Slot result = slotService.updateSlot(1L, mockSlot);

		// Verify the result
		assertEquals(mockSlot, result);
	}

	@Test
	void testUpdateSlot_NegativeScenario() {
		// Mock the behavior of slotRepository.findById() to return Optional.empty()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Slot result = slotService.updateSlot(1L, new Slot());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteSlot_PositiveScenario() {
		// Mock the behavior of slotRepository.findById()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.of(new Slot()));

		// Call the service method
		boolean result = slotService.deleteSlot(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteSlot_NegativeScenario() {
		// Mock the behavior of slotRepository.findById() to return Optional.empty()
		when(slotRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = slotService.deleteSlot(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
