package com.first.java.hello_project.dao;

import com.first.java.hello_project.model.Customer;

import java.util.List;

public interface CustomerDao {
    int insert(Customer customer);
    List<Customer> getEmployeesByCity(String city);
    List<Customer> getEmployeesBySal(double salary);
    List<Customer> getEmployeesByDesignation(String designation);
    List<Customer> getSortedEmployees();
    int update(Customer customer,int id);
    int delete(int id);
    String getCity(int id,String name);
}
