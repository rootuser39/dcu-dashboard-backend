package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Room;
import com.project.smart_dashboard_db.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.orElse(null);
    }

    public Room updateRoom(Long id, Room roomDetails) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setName(roomDetails.getName());
            existingRoom.setCapacity(roomDetails.getCapacity());
            existingRoom.setAirQuality(roomDetails.getAirQuality());
            existingRoom.setNoiseLevel(roomDetails.getNoiseLevel());
            existingRoom.setBuilding(roomDetails.getBuilding());
            return roomRepository.save(existingRoom);
        }
        return null;
    }

    public boolean deleteRoom(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            roomRepository.delete(optionalRoom.get());
            return true;
        }
        return false;
    }
}