package com.employee.service.status.dbservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotNull
    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Column(name = "gender")
    @Size(min = 1, max = 1)
    private String gender;

    @Size(max = 30)
    @Email
    @Column(name = "email_address")
    private String emailId;

    @NotNull
    @Column(name = "mobile_number")
    @Size(min = 8, max = 18)
    private String mobile;
}