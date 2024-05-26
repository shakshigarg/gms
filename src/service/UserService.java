package service;

import db.UserRepository;
import exception.GymServiceException;
import javafx.util.Pair;
import models.*;

public class UserService {
    UserRepository userRepository = new UserRepository();
    GymClassService gymClassService;
    GymService gymService;

    public UserService(GymClassService gymClassService, GymService gymService) {
        this.gymClassService = gymClassService;
        this.gymService = gymService;
    }

    public Integer addUser(String name, UserType userType){
        try {
            User user = null;
            switch (userType) {
                case ADMIN:
                    user = new Admin(name);
                    userRepository.addUser(user);
                    System.out.println("added user");
                    break;
                case CUSTOMER:
                    user = new Customer(name);
                    userRepository.addUser(user);
                    System.out.println("added user");
                    break;
                default:
                    System.out.println("Invalid userType!");
            }
            return user.getId();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void removeUser(Integer userId) throws GymServiceException {
        userRepository.removeUser(userId);
    }

    public void addBooking(Integer gymId,Integer classId, Integer userId){
        try {
            Booking booking;
            Pair<Long, Long> timings = gymClassService.getTimings(classId);
            booking = new Booking(gymId,classId,timings.getKey(),timings.getValue());
            if (userId == null) {
                throw new GymServiceException("UserId cant be null");
            }
            if (!userRepository.isUserPresent(userId)) {
                throw new GymServiceException("UserId not present!");
            }
            User user = userRepository.getUser(userId);
            if (user.getUserType() == UserType.ADMIN) {
                throw new GymServiceException("Admin cant book classes!");
            }
            Customer customer = (Customer) user;
            boolean isOverLappingBookingPresent = customer.getBookings().values().stream().anyMatch(booking1 -> ((booking1.getStartTime() < booking.getStartTime() && booking1.getEndTime() > booking.getEndTime())
                    || (booking1.getStartTime() > booking.getStartTime() && booking1.getEndTime() < booking.getEndTime())));

            if (isOverLappingBookingPresent) {
                throw new GymServiceException("Booking already present!");
            }
            if(gymClassService.isSlotAvailable(booking.getClassId())){
                customer.getBookings().put(booking.getId(), booking);
                gymClassService.addBooking(booking.getClassId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getAllBookings(Integer userId){
        try {
            if (userId == null) {
                System.out.println("UserId cant be null");
                return;
            }
            if (!userRepository.isUserPresent(userId)) {
                System.out.println("UserId not present!");
                return;
            }
            User user = userRepository.getUser(userId);
            if (user.getUserType() == UserType.ADMIN) {
                System.out.println("Admin cant book classes! So no bookings");
                return;
            }
            Customer customer = (Customer) user;
            customer.getBookings().values().stream().forEach(booking -> System.out.println(booking));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cancelBooking(Integer userId, Integer bookingId) throws GymServiceException {
        if (userId == null) {
            throw new GymServiceException("UserId cant be null");
        }
        if (!userRepository.isUserPresent(userId)) {
            throw new GymServiceException("UserId not present!");
        }
        if (bookingId == null) {
            throw new GymServiceException("UserId cant be null");
        }
        User user = userRepository.getUser(userId);
        if (user.getUserType() == UserType.ADMIN) {
            throw new GymServiceException("Admin cant book classes! So no bookings");
        }
        Customer customer = (Customer) user;
        if(customer.getBookings().get(bookingId)==null){
            throw new GymServiceException("Booking not present");
        }
        customer.getBookings().remove(bookingId);
    }
}
