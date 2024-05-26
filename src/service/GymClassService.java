package service;

import db.GymClassRepository;
import exception.GymServiceException;
import javafx.util.Pair;
import models.ClassType;
import models.GymClass;
import utils.Utils;

import java.security.Timestamp;

public class GymClassService {

    GymClassRepository gymClassRepository = GymClassRepository.getInstance();
    GymService gymService;

    public GymClassService(GymService gymService) {
        this.gymService = gymService;
    }

    public boolean isSlotAvailable(Integer classId) throws GymServiceException {
        GymClass gymClass = gymClassRepository.getGymClass(classId);
        if (gymClass.getNoOfBookings() < gymClass.getMaxAcc()) {
            return true;
        }
        return false;
    }

    public void addBooking(Integer classId) throws GymServiceException {
        gymClassRepository.addBooking(classId);
    }

    public Integer addGymClass(Integer gym_id, ClassType class_type, int max_limit, String start_time,String end_time)  {
        try {
            GymClass gymClass = new GymClass(gym_id,class_type, Utils.getTimeInLong(start_time),Utils.getTimeInLong(end_time),max_limit);
            if (!gymClassRepository.isClassPresent(gymClass.getId())) {
                gymClassRepository.addGymClass(gymClass);
                gymService.addGymClass(gymClass.getGymId(), gymClass);
            }
            System.out.println("Added gym class");
            return gymClass.getGymId();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void removeGymClass(Integer gymClassId) throws GymServiceException {
        gymClassRepository.removeGymClass(gymClassId);
    }

    public Pair<Long, Long> getTimings(Integer gymClassId){
        try {
            GymClass gymClass= gymClassRepository.getGymClass(gymClassId);
            return new Pair<>(gymClass.getStartTime(),gymClass.getEndTime());
        } catch (GymServiceException e) {
            throw new RuntimeException(e);
        }

    }


}
