package com.first.java.hello_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Comparable<Customer>{
    @JsonProperty("id")
    private int customerId;
    private String name;
    private  String city;
    private double salary;
    private String designation;

    @Override
    public int compareTo(Customer customer) {
        return (int) (this.getSalary()-customer.getSalary());
    }
}

