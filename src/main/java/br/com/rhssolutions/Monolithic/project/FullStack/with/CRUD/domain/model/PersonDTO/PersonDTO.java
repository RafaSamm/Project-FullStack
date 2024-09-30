package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.PersonDTO;

import br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.domain.model.Person;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record PersonDTO(
        Long id,

        @NotBlank(message = "Name cannot be null or empty")
        String name,

        @NotBlank(message = "Last name cannot be null or empty")
        String lastName,

        @NotBlank(message = "Birth date cannot be null or empty")
        LocalDate birthDate,

        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Phone cannot be null or empty")
        String phone,

        @NotBlank
        @Size(min = 11, max = 11, message = "CPF must have 11 digits")
        String cpf


) {
    public PersonDTO(Person person) {
        this(person.getId(),
                person.getName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getEmail(),
                person.getPhone(),
                person.getCpf());

    }

}



