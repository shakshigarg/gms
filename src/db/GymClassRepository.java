package db;

import exception.GymServiceException;
import models.GymClass;

import java.util.HashMap;

import static exception.GymServiceErrorCode.GYM_ALREADY_EXISTS;

public class GymClassRepository {
    HashMap<Integer, GymClass> gymClasses = new HashMap<>();
    private static final GymClassRepository gymClassRepository = new GymClassRepository();
    public static GymClassRepository getInstance(){
        return gymClassRepository;
    }

    public void addGymClass(GymClass gymClass) throws GymServiceException {
        if (gymClass == null) {
            throw GymServiceException.GYM_NOT_FOUND;
        }
        if (gymClasses.get(gymClass.getId()) != null) {
            throw new GymServiceException(GYM_ALREADY_EXISTS,gymClass.getGymId());
        }
        gymClasses.put(gymClass.getId(),gymClass);
    }

    public void removeGymClass(Integer gymClassId) throws GymServiceException {
        if (gymClassId == null) {
            throw new GymServiceException("gymClassId cant be null");
        }
        if (gymClasses.get(gymClassId) == null) {
            throw new GymServiceException("GymClass doesnt exist");
        }
        gymClasses.remove(gymClassId);
    }

    public boolean isClassPresent(Integer gymClassId) throws GymServiceException {
        if (gymClassId == null) {
            throw new GymServiceException("gymClassId cant be null");
        }
        if (gymClasses.get(gymClassId) == null) {
           return false;
        }
        return true;
    }

    public void addBooking(Integer gymClassId) throws GymServiceException {
        if(!isClassPresent(gymClassId)){
            throw new GymServiceException("Class not present");
        }
        gymClasses.get(gymClassId).setNoOfBookings(gymClasses.get(gymClassId).getNoOfBookings()+1);
    }

    public Integer getNumberOfSlots(Integer gymClassId) throws GymServiceException {
        if(!isClassPresent(gymClassId)){
            throw new GymServiceException("Class not present");
        }
        return gymClasses.get(gymClassId).getNoOfBookings();
    }

    public GymClass getGymClass(Integer gymClassId) throws GymServiceException {
        if(!isClassPresent(gymClassId)){
            throw new GymServiceException("Class not present");
        }
        return gymClasses.get(gymClassId);
    }
}
