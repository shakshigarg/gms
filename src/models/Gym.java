package models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Gym {

    private static AtomicInteger GYM_ID_GENERATOR=new AtomicInteger(1);
    Integer id;
    String name;
    String location;
    int maxAcc;
    HashMap<Integer,GymClass> gymClasses;



    public Gym(String name, String location, int maxAcc) {
        this.id = GYM_ID_GENERATOR.getAndIncrement();
        this.name=name;
        this.location = location;
        this.maxAcc = maxAcc;
        this.gymClasses = new HashMap<>();
    }

    public Gym(Integer id, String name, String location, int maxAcc, HashMap<Integer, GymClass> gymClasses) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.maxAcc = maxAcc;
        this.gymClasses = gymClasses;
    }

    public static AtomicInteger getGymIdGenerator() {
        return GYM_ID_GENERATOR;
    }

    public static void setGymIdGenerator(AtomicInteger gymIdGenerator) {
        GYM_ID_GENERATOR = gymIdGenerator;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxAcc() {
        return maxAcc;
    }

    public void setMaxAcc(int maxAcc) {
        this.maxAcc = maxAcc;
    }

    public HashMap<Integer, GymClass> getGymClasses() {
        return gymClasses;
    }

    public void setGymClasses(HashMap<Integer, GymClass> gymClasses) {
        this.gymClasses = gymClasses;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return maxAcc == gym.maxAcc && Objects.equals(id, gym.id) && Objects.equals(name, gym.name) && Objects.equals(location, gym.location) && Objects.equals(gymClasses, gym.gymClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, maxAcc, gymClasses);
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", maxAcc=" + maxAcc +
                ", gymClasses=" + gymClasses +
                '}';
    }
}
