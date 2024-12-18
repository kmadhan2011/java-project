package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.PaginatedEmployeeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long employeeId);

    PaginatedEmployeeResponse getEmployees(Pageable pageable);
}
