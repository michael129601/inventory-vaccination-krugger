package com.krugger.vaccinationinventory.controllers;


import com.krugger.vaccinationinventory.dto.EmployeeCreateDTO;
import com.krugger.vaccinationinventory.dto.EmployeeDTO;
import com.krugger.vaccinationinventory.dto.EmployeeUpdateDTO;
import com.krugger.vaccinationinventory.events.EmployeeCreated;
import com.krugger.vaccinationinventory.mapper.EmployeeCreateMapper;
import com.krugger.vaccinationinventory.mapper.EmployeeMapper;
import com.krugger.vaccinationinventory.mapper.EmployeeUpdateMapper;
import com.krugger.vaccinationinventory.models.Employee;
import com.krugger.vaccinationinventory.models.enums.VaccinationStatus;
import com.krugger.vaccinationinventory.models.enums.VaccineType;
import com.krugger.vaccinationinventory.services.contract.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("employee")
@Tag(name = "Employee", description = "Crud Employee")
public class EmployeeController {

    @Autowired
    private ApplicationEventPublisher appEventPublisher;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeCreateMapper employeeCreateMapper;

    @Autowired
    private EmployeeUpdateMapper employeeUpdateMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Employee", description = "Add a new employee")
    public ResponseEntity<EmployeeDTO> register(@RequestBody @Valid EmployeeCreateDTO employeeDTO) throws Exception {
        Employee employeeMapped = employeeCreateMapper.toEntity(employeeDTO);
        Employee employee = employeeService.create(employeeMapped);
        appEventPublisher.publishEvent(new EmployeeCreated(this, employee));
        employee = employeeService.getById(employee.getId());
        return new ResponseEntity<>(employeeMapper.toDTO(employee), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Employees", description = "Get all employees")
    public ResponseEntity<List<EmployeeDTO>> getAll() throws Exception {
        List<EmployeeDTO> employees = employeeService.getAll().stream().map(i -> employeeMapper.toDTO(i)).toList();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/by-vaccination-status")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get by status Employees", description = "Get by status Employees")
    public ResponseEntity<List<EmployeeDTO>> getByStatusVaccination(@RequestParam("status") VaccinationStatus status) throws Exception {
        List<EmployeeDTO> employees = employeeService.getByStatusVaccination(status).
                stream().
                map(i -> employeeMapper.toDTO(i)).toList();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/by-vaccination-type")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get by type vaccination", description = "Get by type vaccination")
    public ResponseEntity<List<EmployeeDTO>> getByVaccinationType(@RequestParam("type") VaccineType type) throws Exception {
        List<EmployeeDTO> employees = employeeService.getByVaccinationType(type).
                stream().
                map(i -> employeeMapper.toDTO(i)).toList();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/by-vaccination-at")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get by vaccination at", description = "Get by type vaccination at")
    public ResponseEntity<List<EmployeeDTO>> getByVaccinationAt(@RequestParam("startDate")
                                                                @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
                                                                @RequestParam("endDate")
                                                                @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate) throws Exception {

        List<EmployeeDTO> employees = employeeService.getByBetweenVaccinationAt(startDate,endDate).
                stream().
                map(i -> employeeMapper.toDTO(i)).toList();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get by Id Employees", description = "Get all employees")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable(required = true) Long id) throws Exception {
        EmployeeDTO employee = employeeMapper.toDTO(employeeService.getById(id));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete employees by id", description = "delete employee")
    public ResponseEntity<Void> delete(@PathVariable(required = true) Long id) throws Exception {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update employees by id", description = "update employees")
    public ResponseEntity<EmployeeDTO> update(@PathVariable(required = true) Long id,
                                              @RequestBody @Valid EmployeeUpdateDTO employeeUpdateDTO) throws Exception {
        Employee employee = employeeService.getById(id);
        employeeUpdateMapper.toEntity(employeeUpdateDTO, employee);
        employeeService.update(employee);
        EmployeeDTO employeeDto = employeeMapper.toDTO(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

}
