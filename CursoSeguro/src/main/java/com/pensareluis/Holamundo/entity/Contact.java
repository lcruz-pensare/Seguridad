package com.pensareluis.Holamundo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="thelephone")
    private String telephone;
    @Column(name="city")
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Contact() {
    }

    public Contact(String name, String lastname, String telephone, String city) {
        this.firstname = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.city = city;
    }
}
