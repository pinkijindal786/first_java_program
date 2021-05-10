package com.first.java.hello_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor

public class Employee implements Comparable<Employee> {
        private int empId;
        private String email;
        private  String name;
        private int salary;

        private String city;

        @Override
        public int compareTo(Employee employee1) {
                int compareName = this.getName().compareTo(employee1.getName());
                int compareSalary=  Integer.compare(this.getSalary(), employee1.getSalary());  //j=-1
                int compareCity= this.getCity().compareTo(employee1.getCity());
                int compareEmpId= Integer.compare(this.getEmpId(), employee1.getEmpId());
                if (compareName!= 0)
                {
                        return 1;
                }
                else if (compareSalary != 0)
                {
                        return  1;          //employee1.getSalary()-this.getSalary();
                }
                else if (compareCity!=0){
                        return 1;
                }
                else if(compareEmpId!=0){
                        return 1;
                }
                return 0;
        }
}
