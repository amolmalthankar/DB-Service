package com.employee.service.status.dbservice.controller;

import com.employee.service.status.dbservice.Constants;
import com.employee.service.status.dbservice.model.Employee;
import com.employee.service.status.dbservice.repository.EmployeeRepository;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/rest/db")
public class DBServiceController {

    private EmployeeRepository employeeRepository;

    public DBServiceController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeData(@PathVariable("employeeId") final long employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return employee == null? Constants.DO_NOT_EXISTS : Constants.ALREADY_EXISTS;
    }

    @PostMapping("/add")
    public String addEmployeeData() {
        Employee employee = mockEmplyeeData();
        employee = employeeRepository.save(employee);
        return employee == null? Constants.COULD_NOT_CREATE : Constants.CREATED;
    }

    private Employee mockEmplyeeData() {

        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z')
                .filteredBy(CharacterPredicates.LETTERS).build();

        Employee employee = Employee.builder()
                .firstName(stringGenerator.generate(3, 10))
                .lastName(stringGenerator.generate(3, 10))
                .gender(new Random().nextInt(3) == 1 ? "M" : "F")
                .mobile((new Random().nextInt(999999999) )+"").build();

        return employee;
    }

}
