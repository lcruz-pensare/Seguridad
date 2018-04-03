package mx.pensare.institute.aplication.exception;

import mx.pensare.institute.aplication.constants.ApplicationError;

/**
 * Represents a generic application exception.
 *
 * @author Jorge Álvarez
 * @version 1.0 - 2017/08/31
 */
public class ApplicationException extends RuntimeException {

    /**
     * Application error has been occurred
     */
    private ApplicationError applicationError;

    /**
     * Generic constructor
     *
     * @param message to be show
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * Generic constructor
     *
     * @param message          to be show
     * @param applicationError error has been occurred
     */
    public ApplicationException(String message, ApplicationError applicationError) {
        super(message);
        this.applicationError = applicationError;
    }

    /**
     * Get the error has been occurred
     *
     * @return error has been ocurred
     */
    public ApplicationError getApplicationError() {
        return applicationError;
    }

}