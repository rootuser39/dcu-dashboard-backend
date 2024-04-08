package com.project.smart_dashboard_db.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.smart_dashboard_db.model.Slot;
import com.project.smart_dashboard_db.service.SlotService;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    @PostMapping
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        Slot createdSlot = slotService.createSlot(slot);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSlot);
    }

    @GetMapping("/getById")
    public ResponseEntity<Slot> getSlotById(@RequestParam Long id) {
        Slot slot = slotService.getSlotById(id);
        if (slot != null) {
            return ResponseEntity.ok(slot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Slot> updateSlot(@RequestParam Long id, @RequestBody Slot slotDetails) {
        Slot updatedSlot = slotService.updateSlot(id, slotDetails);
        if (updatedSlot != null) {
            return ResponseEntity.ok(updatedSlot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSlot(@RequestParam Long id) {
        boolean deleted = slotService.deleteSlot(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}