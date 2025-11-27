package com.employeepayroll.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is Required")
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank(message = "Departmet is Required")
    private String department;

    @NotNull(message = "Salary is Required")
    private double salary;

    @NotBlank(message = " Account NO is Required")
    @Size(max = 8, message = "maximum 8 character")
    @Column(unique = true)
    private String acc_No;

    @NotBlank(message = "PF number is Required")
    @Size(max = 6, message = "maximum 6 digit")
    @Pattern(regexp = "^[0-9]+$", message = "PF number must contains numbers only digits")
    @Column(unique = true)
    private String pf_No;

    @NotNull(message = "Join date is required")
    @PastOrPresent
    private LocalDate joinDate;

    @ManyToMany
    @JoinTable(name = "emp_Allowance", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "allowance_id"))
    private List<Allowances> allowances;

    @ManyToOne
    private YearLeaveRule leaveRule;

    @OneToMany
    private List<Attendance> Attendance;

    @OneToMany
    private List<Leave> leaves;


}
