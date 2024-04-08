package com.project.smart_dashboard_db.service;

import org.springframework.stereotype.Service;

import com.project.smart_dashboard_db.model.Slot;
import com.project.smart_dashboard_db.repository.SlotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SlotService {
    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public Slot getSlotById(Long id) {
        Optional<Slot> slotOptional = slotRepository.findById(id);
        return slotOptional.orElse(null);
    }

    public Slot updateSlot(Long id, Slot slotDetails) {
        Optional<Slot> optionalSlot = slotRepository.findById(id);
        if (optionalSlot.isPresent()) {
            Slot existingSlot = optionalSlot.get();
            existingSlot.setFromTime(slotDetails.getFromTime());
            existingSlot.setToTime(slotDetails.getToTime());
            return slotRepository.save(existingSlot);
        }
        return null;
    }

    public boolean deleteSlot(Long id) {
        Optional<Slot> optionalSlot = slotRepository.findById(id);
        if (optionalSlot.isPresent()) {
            slotRepository.delete(optionalSlot.get());
            return true;
        }
        return false;
    }
}