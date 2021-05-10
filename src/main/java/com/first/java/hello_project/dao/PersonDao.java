package com.first.java.hello_project.dao;
import com.first.java.hello_project.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllpeople();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int deletePersonByName(String name);
    int updatePersonById(UUID id, Person person);
}
