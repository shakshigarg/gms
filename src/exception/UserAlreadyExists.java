package exception;

public class UserAlreadyExists extends Exception {
    public UserAlreadyExists() {
        super("User already exists!");
    }
}
