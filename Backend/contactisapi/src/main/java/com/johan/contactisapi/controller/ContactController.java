package com.johan.contactisapi.controller;

import com.johan.contactisapi.entity.Contact;
import com.johan.contactisapi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {


    private final  ContactService contactService;

    @GetMapping
    public Iterable<Contact> List() {
        return contactService.findAll();
    }

    //METODO PARA OBTENER UN SOLO CONTACTO
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }


    // CREACION DE NUEVOS CONTACTOS
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    // ACTUALIZACION DE  CONTACTOS
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form) {
        return contactService.update(id, form);
    }

    // ELIMINAR  CONTACTOS
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }

}
