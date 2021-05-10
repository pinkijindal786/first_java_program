package com.first.java.hello_project.service;

import com.first.java.hello_project.dao.PersonDao;
import com.first.java.hello_project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllpeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(String name){
        return personDao.deletePersonByName(name);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
