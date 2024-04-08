package com.project.smart_dashboard_db.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Slots")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fromTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date toTime;

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}