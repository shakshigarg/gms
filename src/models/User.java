package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class User {

    private static AtomicInteger USER_ID_GENERATOR = new AtomicInteger(1);
    int id;
    String name;
    UserType userType;

    public User(String name,UserType userType) {
        this.id = USER_ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.userType=userType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
