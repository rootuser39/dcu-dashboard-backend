package com.project.smart_dashboard_db.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.smart_dashboard_db.model.RoomSlot;
import com.project.smart_dashboard_db.service.RoomSlotService;

import java.util.List;

@RestController
@RequestMapping("/roomSlots")
public class RoomSlotController {

    private final RoomSlotService roomSlotService;

    public RoomSlotController(RoomSlotService roomSlotService) {
        this.roomSlotService = roomSlotService;
    }

    @GetMapping
    public ResponseEntity<List<RoomSlot>> getAllRoomSlots() {
        List<RoomSlot> roomSlots = roomSlotService.getAllRoomSlots();
        return ResponseEntity.ok(roomSlots);
    }

    @PostMapping
    public ResponseEntity<RoomSlot> createRoomSlot(@RequestBody RoomSlot roomSlot) {
        RoomSlot createdRoomSlot = roomSlotService.createRoomSlot(roomSlot);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoomSlot);
    }

    @GetMapping("/getById")
    public ResponseEntity<RoomSlot> getRoomSlotById(@RequestParam Long id) {
        RoomSlot roomSlot = roomSlotService.getRoomSlotById(id);
        if (roomSlot != null) {
            return ResponseEntity.ok(roomSlot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<RoomSlot> updateRoomSlot(@RequestParam Long id, @RequestBody RoomSlot roomSlotDetails) {
        RoomSlot updatedRoomSlot = roomSlotService.updateRoomSlot(id, roomSlotDetails);
        if (updatedRoomSlot != null) {
            return ResponseEntity.ok(updatedRoomSlot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRoomSlot(@RequestParam Long id) {
        boolean deleted = roomSlotService.deleteRoomSlot(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}