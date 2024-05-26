package models;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {

    private static AtomicInteger BOOKING_ID_GENERATOR = new AtomicInteger(1);
    Integer id;
    Integer gymId;
    Integer classId;

    long startTime;
    long endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Booking(Integer gymId, Integer classId, long startTime, long endTime) {
        this.id = BOOKING_ID_GENERATOR.getAndIncrement();
        this.gymId = gymId;
        this.classId = classId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", gymId=" + gymId +
                ", classId=" + classId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
