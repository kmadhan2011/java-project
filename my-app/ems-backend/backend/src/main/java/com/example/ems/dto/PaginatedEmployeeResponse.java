package com.example.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginatedEmployeeResponse {
    private List<EmployeeDto> employees; // List of employees
    private int currentPage;             // Current page number
    private int totalPages;              // Total number of pages
    private long totalElements;          // Total number of elements
    private boolean isLastPage;
}
