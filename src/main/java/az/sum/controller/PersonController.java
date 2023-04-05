package az.sum.controller;

import az.sum.dto.CreatePersonRequest;
import az.sum.dto.PersonDto;
import az.sum.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<PersonDto> createUser(@RequestBody CreatePersonRequest request){
        return ResponseEntity.ok(service.createUser(request));
    }

@PostMapping("/createAdmin")
    public ResponseEntity<PersonDto> createAdmin(@RequestBody CreatePersonRequest request){
        return ResponseEntity.ok(service.createAdmin(request));
}
}
