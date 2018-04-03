package mx.pensare.institute.aplication.dto;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2017/05/22
 */
public class RestControllerError implements ApplicationDto {

    /**
     * Error occurred
     */
    private String error;

    /**
     * Error code
     */
    private Integer code;

    /**
     * Generic constructor
     */
    public RestControllerError() {
    }

    /**
     * @param error
     */
    public RestControllerError(final String error) {
        super();
        this.error = error;
    }


    /**
     * @param error
     * @param code
     */
    public RestControllerError(final String error,
                               final Integer code) {
        super();
        this.error = error;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}