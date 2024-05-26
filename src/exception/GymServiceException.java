package exception;

public class GymServiceException extends Exception {
    public static final GymServiceException GYM_NOT_FOUND = new GymServiceException(GymServiceErrorCode.GYM_NOT_FOUND);
    GymServiceErrorCode errorCode;


    public GymServiceException(GymServiceErrorCode gymServiceErrorCode, Object...args) {
        super(String.format(gymServiceErrorCode.message,args));
        this.errorCode = gymServiceErrorCode;
    }
    public GymServiceException(String message) {
        super(message);
        this.errorCode = GymServiceErrorCode.INTERNAL_SERVER_ERROR;
    }
}
