package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Reservation;
import com.project.smart_dashboard_db.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.orElse(null);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setRoom(reservationDetails.getRoom());
            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    public boolean deleteReservation(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            reservationRepository.delete(optionalReservation.get());
            return true;
        }
        return false;
    }
}