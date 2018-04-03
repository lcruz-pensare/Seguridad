package mx.pensare.institute.aplication.controller;

//import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Used for common functionalities in a controller
 *
 * @author Jorge Álvarez
 * @version 1.0 - 2017/09/08
 */
public interface CommonController {

    /**
     * Get te user name in the security context
     *
     * @return
     */
    String getUsername();
}