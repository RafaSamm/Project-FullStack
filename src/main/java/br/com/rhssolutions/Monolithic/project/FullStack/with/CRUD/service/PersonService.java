package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.service;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO.PersonDTO;

import java.util.List;

public interface PersonService {

    Person create(PersonDTO person);

    PersonDTO findById(Long id);

    Person update(PersonDTO person, Long id);

    void delete(Long id);

    List<PersonDTO> findAll();
}
