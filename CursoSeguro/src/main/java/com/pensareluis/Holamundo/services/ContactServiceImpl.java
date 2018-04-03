package com.pensareluis.Holamundo.services;

import com.pensareluis.Holamundo.component.ContactConverter;
import com.pensareluis.Holamundo.entity.Contact;
import com.pensareluis.Holamundo.model.ContactModel;
import com.pensareluis.Holamundo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
    @Override
    public ContactModel findContactModelBy(int id) {
       return contactConverter.convertContact2ContactModel(findById(id));
    }

    @Override
    public Contact findById(int id) {
       return contactRepository.findById(id);
    }

    @Override
    public void removeContact(int id) {
        Contact contact=findById(id);
        if(null!= contact){
            contactRepository.delete(contact);
        }

    }

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Autowired
    @Qualifier("contactRepostory")
    private ContactRepository contactRepository;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
       Contact contact = contactRepository.save(contactConverter.ContactconvertContactModel2Contact(contactModel));

        return contactConverter.convertContact2ContactModel(contact);
    }



    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts =contactRepository.findAll();
        List<ContactModel> contactModel = new ArrayList<ContactModel>();
        for (Contact contact: contacts) {
            contactModel.add(contactConverter.convertContact2ContactModel(contact));
        }

        return contactModel;
    }
}

