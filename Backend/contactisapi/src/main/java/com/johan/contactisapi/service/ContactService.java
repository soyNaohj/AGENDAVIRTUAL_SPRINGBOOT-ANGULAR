package com.johan.contactisapi.service;

import com.johan.contactisapi.entity.Contact;
import com.johan.contactisapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return  contactRepository.findAll();
    }

    public  Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public  Contact create(Contact contact){
        contact.setCreateAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public  Contact update(Integer id, Contact form){
        Contact contactFromDb = findById(id);

        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());
        return contactRepository.save(contactFromDb);
    }

    public  void delete(Integer id){
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }

}
