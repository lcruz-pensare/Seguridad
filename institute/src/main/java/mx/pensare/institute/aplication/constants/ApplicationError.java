package mx.pensare.institute.aplication.constants;

import org.springframework.http.HttpStatus;

/**
 * Error to be returned in a HTTP request
 *
 * @author Jorge Álvarez
 * @version 1.0 - 2017/08/31
 */
public enum ApplicationError {

    /**
     * Generic Application error
     */
    ERROR(0x0, "Has occurred an application error.", HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * Not found
     */
    NOT_FOUND(0x01, "Resource not found.", HttpStatus.NOT_FOUND),

    /**
     * Bad request
     */
    BAD_REQUEST(0x02, "Bad request.", HttpStatus.BAD_REQUEST),

    /**
     * Expired JWT
     */
    JWT_EXPIRED(0x03, "JWT expired.", HttpStatus.UNAUTHORIZED),

    /**
     * Not found JWT token
     */
    JWT_NOT_FOUND_TOKEN(0X04, "JWT invalid.", HttpStatus.UNAUTHORIZED),

    /**
     * Bad credential
     */
    BAD_CREDENTIAL(0X05, "Bad credential.", HttpStatus.BAD_REQUEST),

    /**
     * User not found
     */
    ENTITY_NOT_FOUND(0X06, "Entity not found.", HttpStatus.UNAUTHORIZED),

    /**
     * Not content
     */
    NO_CONTENT(0X07, "Not content.", HttpStatus.NO_CONTENT),

    /**
     * Entity alredy exist
     */
    ENTITY_ALREDY_EXIST(0X08, "Entity alredy exist.", HttpStatus.CONFLICT),

    /**
     * Entity invalid
     */
    INVALID(0X09, "Entity invalid.", HttpStatus.CONFLICT),

    /**
     * Entity expired
     */
    EXPIRED(0XA, "Entity expired.", HttpStatus.PRECONDITION_FAILED),

    /**
     * Different password
     */
    DIFFERENT_PASSWORD(0XB, "Different password.", HttpStatus.BAD_REQUEST),

    /**
     * Connection conekta
     */
    CONNECTION_CONEKTA(0XC, "Can't connect to Conekta.", HttpStatus.BAD_REQUEST),

    /**
     * Connection conekta
     */
    PROCESS_CONEKTA(0XD, "Can't process payment.", HttpStatus.BAD_REQUEST),

    /**
     * Bad request
     */
    NO_CREDIT(0XE, "No credit.", HttpStatus.BAD_REQUEST),

    /**
     * Schedule unavailable
     */
    SCHEDULE_UNAVAILABLE(0XF, "Schedule unavailable.", HttpStatus.NO_CONTENT),

    /**
     * Counselor unavailable
     */
    COUNSELOR_UNAVAILABLE(0X10, "Counselor available.", HttpStatus.NO_CONTENT),

    /**
     * Appointment finished
     */
    APPOINMENT_FINISHED(0X11, "Appointment finished.", HttpStatus.NOT_MODIFIED),

    /**
     * Appointment finished
     */
    APPOINMENT_CAN_NOT_START(0X12, "Can not start appointment.", HttpStatus.LOCKED),

    /**
     * Invalid upload
     */
    INVALID_UPLOAD(0X13, "Invalid Upload",  HttpStatus.PRECONDITION_FAILED),

    /**
     * Invalid upload
     */
    FORBIDDEN_TYPE_UPLOAD(0X14, "Forbidden type Upload",  HttpStatus.FORBIDDEN),

    /**
     * Invalid upload
     */
    FORBIDDEN_SIZE_UPLOAD(0X15, "Forbidden size Upload",  HttpStatus.FORBIDDEN),

    /**
     * Invalid upload
     */
    APPOINTMENT_INVALID_STATUS(0X16, "Appointment invalid status",  HttpStatus.PRECONDITION_FAILED),

    /**
     * Invalid parameter
     */
    INVALID_SIGNUP_PARAMETER(0X17, "Invalid parameter",  HttpStatus.BAD_REQUEST);

    /**
     * Error code
     */
    private Integer code;

    /**
     * Message to be displaied in the logger
     */
    private String message;

    /**
     * Http statatus
     */
    private HttpStatus status;

    /**
     * Generic constructor
     *
     * @param code
     */
    ApplicationError(Integer code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }


    /**
     * Get the code Application Error
     *
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Get the message Application Error
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the statusHttp Application Error
     *
     * @return
     */
    public HttpStatus getStatus() {
        return status;
    }

}
