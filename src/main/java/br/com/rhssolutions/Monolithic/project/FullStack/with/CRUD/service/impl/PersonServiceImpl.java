package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.service.impl;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO.PersonDTO;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.repository.PersonRepository;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(PersonDTO person) {
        if (personRepository.findByEmail(person.email()) != null) {
            throw new IllegalArgumentException("Email already exists with this person");
        } else if (personRepository.findByCpf(person.cpf()) != null) {
            throw new IllegalArgumentException("CPF already exists with this person");
        } else {
            var personEntity = new Person();
            BeanUtils.copyProperties(person, personEntity);
            return personRepository.save(personEntity);
        }
    }

    @Override
    public Optional<PersonDTO> findPersonById(Long id) {
        var person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new IllegalArgumentException("Person not found by ID: " + id);
        } else {
            PersonDTO personDTO = new PersonDTO(person.get());
            BeanUtils.copyProperties(person, personDTO);
            return Optional.of(personDTO);
        }
    }

    @Override
    public Person update(Long id, PersonDTO personDTO) {
        var person = personRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Person not found by ID: " + id));
        BeanUtils.copyProperties(personDTO, person);
        return personRepository.save(person);
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        var person = personRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Person not found by ID: " + id));
        personRepository.delete(person);
        return Map.of("deleted", true);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> persons = personRepository.findAll();
        if (persons.isEmpty()) {
            throw new IllegalArgumentException("No person found");
        } else {
            return persons.stream().map(person -> {
                PersonDTO personDTO = new PersonDTO(person);
                BeanUtils.copyProperties(person, personDTO);
                return personDTO;
            }).toList();
        }
    }

}


