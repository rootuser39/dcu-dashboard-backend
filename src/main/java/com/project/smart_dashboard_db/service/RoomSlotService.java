package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.RoomSlot;
import com.project.smart_dashboard_db.repository.RoomSlotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomSlotService {
    private final RoomSlotRepository roomSlotRepository;

    public RoomSlotService(RoomSlotRepository roomSlotRepository) {
        this.roomSlotRepository = roomSlotRepository;
    }

    public List<RoomSlot> getAllRoomSlots() {
        return roomSlotRepository.findAll();
    }

    public RoomSlot createRoomSlot(RoomSlot roomSlot) {
        return roomSlotRepository.save(roomSlot);
    }

    public RoomSlot getRoomSlotById(Long id) {
        Optional<RoomSlot> roomSlotOptional = roomSlotRepository.findById(id);
        return roomSlotOptional.orElse(null);
    }

    public RoomSlot updateRoomSlot(Long id, RoomSlot roomSlotDetails) {
        Optional<RoomSlot> optionalRoomSlot = roomSlotRepository.findById(id);
        if (optionalRoomSlot.isPresent()) {
            RoomSlot existingRoomSlot = optionalRoomSlot.get();
            existingRoomSlot.setRoom(roomSlotDetails.getRoom());
            return roomSlotRepository.save(existingRoomSlot);
        }
        return null;
    }

    public boolean deleteRoomSlot(Long id) {
        Optional<RoomSlot> optionalRoomSlot = roomSlotRepository.findById(id);
        if (optionalRoomSlot.isPresent()) {
            roomSlotRepository.delete(optionalRoomSlot.get());
            return true;
        }
        return false;
    }
}