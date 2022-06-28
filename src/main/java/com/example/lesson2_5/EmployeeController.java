package com.example.lesson2_5;

import com.example.lesson2_5.Exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_5.Exceptions.EmployeeStorageIsFullException;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/all")
    public List<Employee> getAll (){
        return employeeService.getAll();
    }

    @RequestMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName ){
        return employeeService.addEmployee(firstName, lastName);
    }

    @RequestMapping("/remove")
    public Employee deleteEmployee (@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName ) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @RequestMapping("/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName ) {
        return employeeService.findEmployee(firstName, lastName);
    }

}
