package com.first.java.hello_project.service;

import com.first.java.hello_project.dao.EmployeeDao;
import com.first.java.hello_project.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;
    public int insert(Employee employee) {
        return employeeDao.insert(employee);
    }
    public List<Employee> getList(){
        return employeeDao.getList();
    }

    public int delete(int empId){
        return employeeDao.delete(empId);
    }
    public int update(int empId,Employee employee){
     return employeeDao.update(empId,employee);
    }
    public List<Employee> getSortedList(){
    List<Employee> employeeList=employeeDao.getList();
        Collections.sort(employeeList);
        return employeeList;
    }

}
