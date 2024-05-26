package models;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class GymClass {

    private static AtomicInteger GYM_CLASS_ID_GENERATOR = new AtomicInteger(1);

    Integer id;
    Integer gymId;
    long startTime;
    long endTime;
    int maxAcc;
    ClassType classType;
    int noOfBookings;

    public GymClass(Integer gymId, ClassType classType, long startTime, long endTime, int maxAcc) {
        this.id = GYM_CLASS_ID_GENERATOR.getAndIncrement();
        this.classType = classType;
        this.gymId = gymId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxAcc = maxAcc;
        this.noOfBookings = 0;
    }

    public Integer getId() {
        return id;
    }


    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
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

    public int getMaxAcc() {
        return maxAcc;
    }

    public void setMaxAcc(int maxAcc) {
        this.maxAcc = maxAcc;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getNoOfBookings() {
        return noOfBookings;
    }

    public void setNoOfBookings(int noOfBookings) {
        this.noOfBookings = noOfBookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymClass gymClass = (GymClass) o;
        return startTime == gymClass.startTime && endTime == gymClass.endTime && maxAcc == gymClass.maxAcc && noOfBookings == gymClass.noOfBookings && Objects.equals(id, gymClass.id) && Objects.equals(gymId, gymClass.gymId) && classType == gymClass.classType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gymId, startTime, endTime, maxAcc, classType, noOfBookings);
    }

    @Override
    public String toString() {
        return "GymClass{" +
                "id=" + id +
                ", gymId='" + gymId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxAcc=" + maxAcc +
                ", classType=" + classType +
                ", noOfBookings=" + noOfBookings +
                '}';
    }


}
