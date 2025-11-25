package com.employeepayroll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is Required")
    private LocalDate date;

    @NotNull(message = "Status is Required")
    private boolean status;

    @ManyToOne
    private Employee employee;


//    @AssertTrue(message = "date must be today's date") //only add today date
//    public boolean isTodayDate() {
//        return date != null && date.equals(LocalDate.now());
//    }
}