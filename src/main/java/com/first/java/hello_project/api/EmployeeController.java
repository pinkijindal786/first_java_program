package com.first.java.hello_project.api;

import com.first.java.hello_project.model.Employee;
import com.first.java.hello_project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/insert")
    public int insert(@RequestBody @NonNull @Valid @NotBlank Employee employee){
        return employeeService.insert(employee);
    }

    @GetMapping("/get/List")
    public List<Employee> getList()
    {
        return employeeService.getList();
    }
    @DeleteMapping("/delete/{empId}")
    public int delete(@PathVariable("emId") int empId){
        return employeeService.delete(empId);
    }
    @PutMapping("update/{empId}")
    public int update(@PathVariable("empId") int empId, @RequestBody Employee employee){
        return employeeService.update(empId,employee);
    }
    @GetMapping("get/sortedList")
    public List<Employee> getSortedList(){
        return employeeService.getSortedList();
    }
}
