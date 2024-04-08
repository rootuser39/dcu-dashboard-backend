package com.project.smart_dashboard_db.model;

import javax.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String name;

    private int capacity;

    private float airQuality;

    private float noiseLevel;

    private String building;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(float airQuality) {
        this.airQuality = airQuality;
    }

    public float getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(float noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}