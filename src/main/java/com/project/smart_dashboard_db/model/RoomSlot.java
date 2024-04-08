package com.project.smart_dashboard_db.model;

import javax.persistence.*;

@Entity
@Table(name = "Rooms_slots")
public class RoomSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomSlotId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private boolean active;

    public Long getRoomSlotId() {
        return roomSlotId;
    }

    public void setRoomSlotId(Long roomSlotId) {
        this.roomSlotId = roomSlotId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}