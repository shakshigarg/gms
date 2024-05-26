package exception;

import javax.xml.ws.Response;

public enum GymServiceErrorCode {
    GYM_NOT_FOUND(500,"Gym not found"),
    USER_ALREADY_EXISTS(400,"BAD request"),
    GYM_CANT_BE_NULL(400,"Gym cant be null"),
    GYM_ALREADY_EXISTS(400,"Gym with gymId %d already exists"),
    INTERNAL_SERVER_ERROR(500,"Internal server error");
    int errorCode;
    String message;
    GymServiceErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


}
