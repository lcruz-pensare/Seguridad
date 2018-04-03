package com.pensareluis.Holamundo.component;

import com.pensareluis.Holamundo.entity.Contact;
import com.pensareluis.Holamundo.model.ContactModel;
import org.springframework.stereotype.Component;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Component("contactConverter")
public class ContactConverter {
    public Contact ContactconvertContactModel2Contact(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setCity(contactModel.getCity());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setId(contactModel.getId());
        contact.setFirstname(contactModel.getFirstname());
        return contact;
    }
    public ContactModel convertContact2ContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setCity(contact.getCity());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setId(contact.getId());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        return contactModel;
            }
}
