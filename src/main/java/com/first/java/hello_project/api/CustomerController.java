package com.first.java.hello_project.api;

import com.first.java.hello_project.model.Customer;
import com.first.java.hello_project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/insert")
    public int insertIntoCustomerDb(@RequestBody @NonNull @Valid @NotBlank Customer customer){
        return customerService.insert(customer);
    }
    @GetMapping("/get/city")
    public List<Customer> customerListByCity(@RequestParam ("city") String city){
        return customerService.listByCity(city);
    }
    @GetMapping("/get/salary")
    public List<Customer> customerListBySalary(@RequestParam ("salary") double salary){
        return customerService.listBySalary(salary);
    }
    @GetMapping("/get/designation")
    public List<Customer> customerListByDesignation(@RequestParam ("designation") String designation){
        return customerService.listByDesignation(designation);
    }
    @GetMapping("/get/sortedList")
    public List<Customer> customerSortedList(){
        return customerService.sortedList();
    }


    @PutMapping("/update/{id}")
    public int update(@PathVariable ("id") int id, @RequestBody Customer customer){
        return customerService.update(customer,id);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id){
        return customerService.delete(id);
    }
    @GetMapping("/get/sortedListBySalary")
    public List<Customer> customerListBySalary(){
        return customerService.sortListBySalary();
    }
    @GetMapping("/get/{id}/{name}")
    public String getCity(@PathVariable ("id") int id, @PathVariable ("name") String name){
        return customerService.getCity(id,name);
    }
    @GetMapping("/get/CityByIdName")
    public String getCityByName(@RequestParam ("id") int id, @RequestParam ("name") String name){
        return customerService.getCity(id,name);
    }

}
