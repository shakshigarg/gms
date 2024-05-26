package db;

import exception.GymServiceException;
import models.Gym;

import java.util.HashMap;

public class GymRepository {
    HashMap<Integer, Gym> gyms = new HashMap<>();
    private static final GymRepository gymRepository = new GymRepository();
    public static GymRepository getInstance(){
        return gymRepository;
    }

    public void addGym(Gym gym) throws GymServiceException {
        if (gym == null) {
            throw new GymServiceException("Gym cant be null");
        }
        if (gyms.get(gym.getId()) != null) {
            throw new GymServiceException("Gym Already exists");
        }
        gyms.put(gym.getId(),gym);
    }

    public void removeGym(Integer gymId) throws GymServiceException {
        if (gymId == null) {
            throw new GymServiceException("GymId cant be null");
        }
        if (gyms.get(gymId) == null) {
            throw new GymServiceException("Gym doesnt exist");
        }
        gyms.remove(gymId);
    }

    public boolean isGymPresent(Integer gymId) throws GymServiceException {
        if(gymId==null){
            throw new GymServiceException("GymId cant be null");
        }
        if (gyms.get(gymId) == null) {
            return false;
        }
        return true;
    }

    public Gym getGym(Integer gymId) throws GymServiceException {
        if(!isGymPresent(gymId)){
            throw new GymServiceException("Gym doesnt exist");
        }
        return gyms.get(gymId);
    }



}
