package com.example.lesson2_5;

import com.example.lesson2_5.Exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_5.Exceptions.EmployeeNotFoundException;
import com.example.lesson2_5.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final int LIMIT = 10;
    private static List<Employee> emp1 = new ArrayList ();

    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (emp1.contains(emp)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (emp1.size() < LIMIT) {
            emp1.add(emp);
            return emp;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
            if (!emp1.contains(emp)) {
                throw new EmployeeNotFoundException();
            }
        emp1.remove(emp);
        return emp;
}

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
            if (!emp1.contains(emp)){
                throw new EmployeeNotFoundException();
            }
        return emp;
    }
    public List <Employee> getAll (){
        return new ArrayList<> (emp1);
    }
}
