package az.sum.service;

import az.sum.dto.CreatePersonRequest;
import az.sum.dto.PersonDto;
import az.sum.dto.converter.PersonDtoConverter;
import az.sum.exception.AccountAlreadyExistException;
import az.sum.exception.PersonNotFoundException;
import az.sum.exception.UserNotFoundException;
import az.sum.model.Person;
import az.sum.model.Role;
import az.sum.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
private final PersonRepository personRepository;
private final PersonDtoConverter converter;


public PersonDto createUser(CreatePersonRequest request){
    Person person=new Person(
            request.getFirstName(),
            request.getLastName(),
            request.getMail(),
            Role.USER,
            request.getPassword()
            );

return converter.convertToDto(personRepository.save(person));
}
public PersonDto createAdmin(CreatePersonRequest request){
    Person person=new Person(
            request.getFirstName(),
            request.getLastName(),
            request.getMail(),
            Role.ADMIN,
            request.getPassword()
    );

    return converter.convertToDto(personRepository.save(person));
}
//private void findPersonByMail(String mail){
//    Optional<Person> person=personRepository.findByMail(mail);
//    person.ifPresent(person1 -> {throw new AccountAlreadyExistException("Account already exists");});
//}

protected void checkUserExistOrNot(String mail){
personRepository.findByMail(mail).orElseThrow(
        ()->new UserNotFoundException("User couldn't be found by following mail: " + mail));
}
protected void chekPersonIsCourierOrNot(String mail){
    personRepository.findByMail(mail).orElseThrow(
            ()-> new PersonNotFoundException("Person couldn't be found by following mail:  " + mail));
}
protected Person checkPersonExistOrNot(String mail){
return
        personRepository.findByMail(mail).orElseThrow(
                ()->new PersonNotFoundException("Person couldn't be found by following mail:  " + mail));
}
}


