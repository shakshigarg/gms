
import models.ClassType;
import models.UserType;
import service.GymClassService;
import service.GymService;
import service.UserService;

public class Main {
    public static void main(String[] args) {

        GymService gymService = new GymService();
        GymClassService gymClassService = new GymClassService(gymService);
        UserService userService = new UserService(gymClassService, gymService);

        Integer user1 = userService.addUser("Sakshi", UserType.ADMIN);
        Integer user2 = userService.addUser("Mahi", UserType.CUSTOMER);

        Integer gymId1 = gymService.addGym("Cult1", "ballendur", 20);
        Integer gymId2 = gymService.addGym("Cult2", "ballendur", 20);

        Integer gymClass1 = gymClassService.addGymClass(gymId1, ClassType.ZUMBA, 20, "2024-03-03 01:00:00", "2024-03-03 02:00:00");
        Integer gymClass2 = gymClassService.addGymClass(gymId1, ClassType.BURN, 20, "2024-03-03 01:00:00", "2024-03-03 02:00:00");

        Integer gymClass3 = gymClassService.addGymClass(gymId2, ClassType.ZUMBA, 20, "2024-03-03 01:00:00", "2024-03-03 02:00:00");
        Integer gymClass4 = gymClassService.addGymClass(gymId2, ClassType.BURN, 20, "2024-03-03 01:00:00", "2024-03-03 02:00:00");

        userService.addBooking(gymId1, gymClass1, user2);
        userService.getAllBookings(user2);


    }
}