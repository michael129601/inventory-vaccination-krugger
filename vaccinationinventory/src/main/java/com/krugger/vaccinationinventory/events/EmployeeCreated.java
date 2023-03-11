package com.krugger.vaccinationinventory.events;

import com.krugger.vaccinationinventory.models.Employee;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class EmployeeCreated  extends ApplicationEvent {

    private  final Employee employee;

    public EmployeeCreated(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

}