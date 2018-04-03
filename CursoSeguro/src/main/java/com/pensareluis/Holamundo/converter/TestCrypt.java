package com.pensareluis.Holamundo.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/27
 */
public class TestCrypt {
    public static void main (String [] args){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("celldweller"));
    }
}
