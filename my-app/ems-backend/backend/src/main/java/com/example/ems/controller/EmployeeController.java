package com.example.ems.controller;


import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.PaginatedEmployeeResponse;
import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity <EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        System.out.println(employeeId);
        return ResponseEntity.ok(employeeDto);

    }
    // Build GET API for Pagination
    @GetMapping
    public ResponseEntity<PaginatedEmployeeResponse> getEmployees(
            @RequestParam(defaultValue = "0") int page,    // Page number (default = 0)
            @RequestParam(defaultValue = "5") int size     // Page size (default = 5)
    ) {
        Pageable pageable = PageRequest.of(page, size); // Create Pageable object
        PaginatedEmployeeResponse response = employeeService.getEmployees(pageable);
        return ResponseEntity.ok(response);
    }
}
