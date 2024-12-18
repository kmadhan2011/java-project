package com.example.ems.service.Impl;

import com.example.ems.Mapper.EmployeeMapper;
import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.PaginatedEmployeeResponse;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find employee with ID: " + employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public PaginatedEmployeeResponse getEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable); // Get paginated data

        // Map the Employee entities to EmployeeDto
        List<EmployeeDto> employeeDtos = employeePage.getContent()
                .stream()
                .map(EmployeeMapper::maptoEmployeeDto)
                .collect(Collectors.toList());

        // Build and return the PaginatedEmployeeResponse DTO
        return new PaginatedEmployeeResponse(
                employeeDtos,
                employeePage.getNumber(),
                employeePage.getTotalPages(),
                employeePage.getTotalElements(),
                employeePage.isLast()
        );
    }
}
