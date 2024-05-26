package db;

import exception.GymServiceException;
import exception.UserAlreadyExists;
import models.Booking;
import models.Customer;
import models.User;
import models.UserType;

import java.util.HashMap;

public class UserRepository {
    HashMap<Integer, User> users= new HashMap<>();
    private static final UserRepository userRepository = new UserRepository();

    public static UserRepository getInstance() {
        return userRepository;
    }

    public void addUser(User user) throws GymServiceException, UserAlreadyExists {
        if (user == null) {
            throw new GymServiceException("User cant be null");
        }
        if (isUserPresent(user.getId())) {
            throw new UserAlreadyExists();
        }
        users.put(user.getId(), user);
    }

    public void removeUser(Integer userId) throws GymServiceException {
        if(!isUserPresent(userId)){
            throw new GymServiceException("User not present!");
        }
        users.remove(userId);
    }

    public boolean isUserPresent(Integer userId) throws GymServiceException {
        if (userId == null) {
            throw new GymServiceException("UserId cant be null");
        }
        if (users.get(userId) != null) {
            return true;
        }
        return false;
    }

    public UserType getUserType(Integer userId) throws GymServiceException {
        if(!isUserPresent(userId)){
            throw new GymServiceException("User not present!");
        }
        return users.get(userId).getUserType();
    }

    public User getUser(Integer userId) throws GymServiceException {
        if(!isUserPresent(userId)){
            throw new GymServiceException("User not present!");
        }
        return users.get(userId);
    }
}
