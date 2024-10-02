package com.johan.contactisapi.controller;

import com.johan.contactisapi.entity.Contact;
import com.johan.contactisapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public Iterable<Contact> List() {
        return  contactRepository.findAll();
    }

    //METODO PARA OBTENER UN SOLO CONTACTO
    @GetMapping("{id}")
    public  Contact get(@PathVariable Integer id){
    return contactRepository
            .findById(id)
            .orElse(null);
    }


    // CREACION DE NUEVOS CONTACTOS
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public  Contact create(@RequestBody Contact contact){
        contact.setCreateAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    // ACTUALIZACION DE  CONTACTOS
    @PutMapping("{id}")
    public  Contact update(@PathVariable Integer id,
                           @RequestBody Contact form){
        Contact contactFromDb = contactRepository
                .findById(id)
                .orElse(null);
    contactFromDb.setName(form.getName());
    contactFromDb.setEmail(form.getEmail());
        return contactRepository.save(contactFromDb);
    }

    // ELIMINAR  CONTACTOS
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public  void delete(@PathVariable Integer id){
        Contact contactFromDb = contactRepository
                .findById(id)
                .orElse(null);
        contactRepository.delete(contactFromDb);
    }

}
