package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.service;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO.PersonDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonService {

    Person create(PersonDTO person);

    Optional<PersonDTO> findPersonById(Long id);

    Person update(Long id, PersonDTO person);

    Map<String, Boolean> delete(Long id);

    List<PersonDTO> findAll();
}
