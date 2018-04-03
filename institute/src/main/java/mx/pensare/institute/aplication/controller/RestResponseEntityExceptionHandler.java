package mx.pensare.institute.aplication.controller;

import mx.pensare.institute.aplication.constants.ApplicationError;
import mx.pensare.institute.aplication.dto.RestControllerError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Rest Controller Exception Handler
 * <p>
 * source: https://github.com/eugenp/tutorials/tree/master/spring-security-rest
 *
 * @author Alejandro Martin
 * @version 1.0 - 2017/05/22
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 400 - Bad request
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex,
            final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final RestControllerError apiError = new RestControllerError(ApplicationError.BAD_REQUEST.getMessage());
        return handleExceptionInternal(ex, apiError, headers, ApplicationError.BAD_REQUEST.getStatus(), request);
    }

    /**
     * 404 - Not found exception
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            final NoHandlerFoundException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final String error = "No handler found for "
                + ex.getHttpMethod() + " " + ex.getRequestURL();

        final RestControllerError apiError = new RestControllerError(ApplicationError.NOT_FOUND.getMessage());
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), ApplicationError.NOT_FOUND.getStatus());
    }



    /**
     * HTTP 500 - Internal server error
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);
        //
        final RestControllerError apiError =
                new RestControllerError(ApplicationError.ERROR.getMessage());
        return new ResponseEntity<Object>(apiError,
                new HttpHeaders(), ApplicationError.ERROR.getStatus());
    }

}