package com.johan.contactisapi.repository;

import com.johan.contactisapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> { //interatua con la BD para consultas
}
