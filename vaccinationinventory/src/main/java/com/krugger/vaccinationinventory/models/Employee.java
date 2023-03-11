package com.krugger.vaccinationinventory.models;


import com.krugger.vaccinationinventory.models.enums.VaccinationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", unique = true, nullable = false, length = 10)
    private String dni;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address",  length = 200)
    private String address;

    @Column(name = "celphone", length = 20)
    private String celphone;

    @OneToOne(mappedBy = "employee")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "vaccination_status", nullable = true)
    private VaccinationStatus vaccinationStatus;

    // validar cascade
    @OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL })
    private List<VaccinationEmployee> vaccinationEmployee;

}