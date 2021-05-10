package com.first.java.hello_project.dao;

import com.first.java.hello_project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sqlInsert= "INSERT INTO person(id,name) VALUES (uuid_generate_v1(),?)";
        return jdbcTemplate.update(sqlInsert,new Object[]{person.getName()},new int[] {Types.VARCHAR});
    }

    @Override
    public List<Person> selectAllpeople() {
        final String sql= "SELECT id,name FROM person";
       return jdbcTemplate.query(sql, (resultSet ,i) ->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name= resultSet.getString("name");
            return new Person(id,name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql= "SELECT id,name FROM person WHERE id = ?";
        Person person= jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet ,i) ->{
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name= resultSet.getString("name");
            return new Person(personId,name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
        public int deletePersonByName(String name) {
            final String sqlQuery="DELETE FROM person WHERE name=?";
            return jdbcTemplate.update(sqlQuery, new Object[]{name},new int[] {Types.VARCHAR});
        }


    @Override
    public int updatePersonById(UUID id, Person person) {
//        final String sqlUpdate= "Update person set name=? where id=?";
//        return jdbcTemplate.update(sqlUpdate, new Object[]{person.getName(),id}, new int[])
    return 0;
    }
}
