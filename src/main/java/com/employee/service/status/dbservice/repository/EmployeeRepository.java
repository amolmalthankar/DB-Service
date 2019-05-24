package com.employee.service.status.dbservice.repository;

import com.employee.service.status.dbservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(long employeeId);
}
