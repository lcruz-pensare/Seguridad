package com.pensareluis.Holamundo.services;

import com.pensareluis.Holamundo.entity.Contact;
import com.pensareluis.Holamundo.model.ContactModel;


import java.util.List;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */

public interface ContactService {
    public abstract ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
    public abstract Contact findById(int id);
    public abstract void removeContact(int id);
    public abstract ContactModel findContactModelBy(int id);

}
