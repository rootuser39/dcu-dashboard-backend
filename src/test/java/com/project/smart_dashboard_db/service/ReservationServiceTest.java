package com.project.smart_dashboard_db.service;

import com.project.smart_dashboard_db.model.Reservation;
import com.project.smart_dashboard_db.repository.ReservationRepository;
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
class ReservationServiceTest {

	@Mock
	private ReservationRepository reservationRepository;

	@InjectMocks
	private ReservationService reservationService;

	@Test
	void testGetAllReservations() {
		// Create mock reservations
		List<Reservation> mockReservations = Arrays.asList(new Reservation(), new Reservation());
		// Mock the behavior of reservationRepository.findAll()
		when(reservationRepository.findAll()).thenReturn(mockReservations);

		// Call the service method
		List<Reservation> result = reservationService.getAllReservations();

		// Verify the result
		assertEquals(mockReservations, result);
	}

	@Test
	void testCreateReservation() {
		// Create a mock reservation
		Reservation mockReservation = new Reservation();
		// Mock the behavior of reservationRepository.save()
		when(reservationRepository.save(mockReservation)).thenReturn(mockReservation);

		// Call the service method
		Reservation result = reservationService.createReservation(mockReservation);

		// Verify the result
		assertEquals(mockReservation, result);
	}

	@Test
	void testGetReservationById_PositiveScenario() {
		// Create a mock reservation
		Reservation mockReservation = new Reservation();
		// Mock the behavior of reservationRepository.findById()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(mockReservation));

		// Call the service method
		Reservation result = reservationService.getReservationById(1L);

		// Verify the result
		assertEquals(mockReservation, result);
	}

	@Test
	void testGetReservationById_NegativeScenario() {
		// Mock the behavior of reservationRepository.findById() to return
		// Optional.empty()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Reservation result = reservationService.getReservationById(1L);

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testUpdateReservation_PositiveScenario() {
		// Create a mock reservation
		Reservation mockReservation = new Reservation();
		// Mock the behavior of reservationRepository.findById()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(mockReservation));
		// Mock the behavior of reservationRepository.save()
		when(reservationRepository.save(mockReservation)).thenReturn(mockReservation);

		// Call the service method
		Reservation result = reservationService.updateReservation(1L, mockReservation);

		// Verify the result
		assertEquals(mockReservation, result);
	}

	@Test
	void testUpdateReservation_NegativeScenario() {
		// Mock the behavior of reservationRepository.findById() to return
		// Optional.empty()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		Reservation result = reservationService.updateReservation(1L, new Reservation());

		// Verify the result is null
		assertNull(result);
	}

	@Test
	void testDeleteReservation_PositiveScenario() {
		// Mock the behavior of reservationRepository.findById()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(new Reservation()));

		// Call the service method
		boolean result = reservationService.deleteReservation(1L);

		// Verify the result
		assertTrue(result);
	}

	@Test
	void testDeleteReservation_NegativeScenario() {
		// Mock the behavior of reservationRepository.findById() to return
		// Optional.empty()
		when(reservationRepository.findById(anyLong())).thenReturn(Optional.empty());

		// Call the service method with a non-existent ID
		boolean result = reservationService.deleteReservation(1L);

		// Verify the result is false
		assertFalse(result);
	}
}
