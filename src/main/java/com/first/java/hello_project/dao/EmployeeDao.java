package com.first.java.hello_project.dao;

import com.first.java.hello_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface EmployeeDao {
     int insert(Employee employee);
     List<Employee> getList();
     int delete(int id);
     int update(int id,Employee employee);
}
