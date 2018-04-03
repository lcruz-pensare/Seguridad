package com.pensareluis.Holamundo.repository;

import com.pensareluis.Holamundo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Repository("contactRepostory")
public interface ContactRepository extends JpaRepository<Contact,Serializable>{
    public abstract Contact findById(int id);
}
