package com.first.java.hello_project.service;

import com.first.java.hello_project.dao.CustomerDao;
import com.first.java.hello_project.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;
    public int insert(Customer customer){
        return customerDao.insert(customer);
    }
    public List<Customer> listBySalary(double salary){
        return customerDao.getEmployeesBySal(salary);
    }

    public List<Customer> listByCity(String city){
        return customerDao.getEmployeesByCity(city);
    }

    public List<Customer> listByDesignation(String designation){
        return customerDao.getEmployeesByDesignation(designation);
    }
    public List<Customer> sortedList(){
        return customerDao.getSortedEmployees();
    }
    public int update(Customer customer,int id){
      return customerDao.update(customer,id);
    }
    public int delete(int id){
        return customerDao.delete(id);
    }
    public List<Customer> sortListBySalary(){
        List<Customer> customerList = sortedList();
        Collections.sort(customerList);
         return customerList;
    }
    public String getCity(int id,String name){
        return customerDao.getCity(id,name);
    }
}
