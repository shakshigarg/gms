package service;

import db.GymRepository;
import exception.GymServiceException;
import models.Gym;
import models.GymClass;

public class GymService {
    GymRepository gymRepository=new GymRepository();


    public void addGymClass(Integer gymId, GymClass gymClass) throws GymServiceException {
        if(gymRepository.isGymPresent(gymId)){
            Gym gym=gymRepository.getGym(gymId);
            if(gym.getGymClasses().get(gymClass.getId())!=null){
                throw new GymServiceException("Class already mapped!");
            }else {
                gym.getGymClasses().put(gymClass.getId(),gymClass);
            }
        }else {
            throw new GymServiceException("Gym not present!");
        }
    }

    public Integer addGym(String name,String location,int max_accomodation) {
        Gym gym=new Gym(name,location,max_accomodation);
        try {
            gymRepository.addGym(gym);
            System.out.println("added gym");
            return gym.getId();
        } catch (GymServiceException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void removeGym(Integer gymId) throws GymServiceException {
        gymRepository.removeGym(gymId);
    }
}
