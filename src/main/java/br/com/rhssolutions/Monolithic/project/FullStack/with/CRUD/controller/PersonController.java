package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.controller;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO.PersonDTO;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }


}
