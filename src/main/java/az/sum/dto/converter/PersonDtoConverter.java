package az.sum.dto.converter;

import az.sum.dto.CreatePersonRequest;
import az.sum.dto.PersonDto;
import az.sum.dto.RoleDto;
import az.sum.model.Person;
import az.sum.model.Role;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoConverter {


public PersonDto convertToDto(Person person){
return new PersonDto(person.getFirstName(),person.getLastName(),
        person.getMail(), RoleDto.valueOf(person.getRole().name()));
}
}
