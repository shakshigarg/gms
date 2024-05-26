package models;

public class Admin extends User{
    Integer gymId;

    public Admin(String name) {
        super(name,UserType.ADMIN);
        this.gymId = gymId;
    }
}
