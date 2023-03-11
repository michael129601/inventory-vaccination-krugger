package com.krugger.vaccinationinventory.models;

import com.krugger.vaccinationinventory.models.enums.VaccineType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vaccination_employee")
public class VaccinationEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "vaccine_type", length = 50)
    private VaccineType typeVaccine;

    @Column(name = "vaccinated_at")
    private LocalDate vaccinatedAt;

    @Column(name = "dose_number")
    private Integer doseNumber;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

}
