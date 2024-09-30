package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.repository;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    PersonDTO findByEmail(String email);

    PersonDTO findByCpf(String cpf);
}
