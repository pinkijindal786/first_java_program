package com.first.java.hello_project.dao;

import com.first.java.hello_project.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Employee employee) {
        final String sqlInsert= "INSERT INTO employee (empId,name,city,salary,email) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sqlInsert, new Object[]
                {employee.getEmpId(),employee.getName(),employee.getCity(),employee.getSalary(),employee.getEmail()},
        new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
    }

    @Override
    public List<Employee> getList() {
        final String sqlFetch="SELECT * FROM employee";
        return jdbcTemplate.query(sqlFetch,
                (resultSet ,i)->{
                    int id = resultSet.getInt("empId");
                    String name_emp= resultSet.getString("name");
                    String city_emp= resultSet.getString("city");
                    int salary_emp= resultSet.getInt("salary");
                    String email_emp= resultSet.getString("email");
                    return  new Employee(id,name_emp,city_emp,salary_emp,email_emp);
                });
    }

    @Override
    public int delete(int empId) {
        final String sqlDelete= "DELETE FROM employee WHERE empId=?";
        return jdbcTemplate.update(sqlDelete,new Object[]{empId}, new int[]{Types.INTEGER});
    }

    @Override
    public int update(int empId, Employee employee) {
        final String sqlUpdate = "Update employee set name=?, city=?, salary=?, email=? where empId=?";
        return jdbcTemplate.update(
                sqlUpdate,
                new Object[]{employee.getName(), employee.getCity(), employee.getSalary(),employee.getEmail(), empId},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER});
    }
}
