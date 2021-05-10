package com.first.java.hello_project.api;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.first.java.hello_project.model.Person;
import com.first.java.hello_project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public int addPerson(@Valid @NonNull @RequestBody Person person){
        return personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{name}")
    public int deletePersonById(@PathVariable("name") String name){
        return personService.deletePerson(name);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
