package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	    @Autowired
	    private EmployeeRepository employeeRepository;

	    public Employee getNthLevelManager(String employeeId, int level) {
	        // Implement logic to retrieve the nth level manager of the employee
	        // This could involve recursive calls or a custom query based on your data structure
	        // Example: Retrieve the employee by ID, find the reportsTo ID, and repeat until the nth level
	        // Return null if the nth level manager is not found

	        // Sample logic (not optimized for performance)
	        Employee employee = employeeRepository.findById(employeeId).orElse(null);
	        while (employee != null && level > 0) {
	            employee = employeeRepository.findById(employee.getReportsTo()).orElse(null);
	            level--;
	        }
	        return employee;
	    }
	
	    
	    public List<Employee> getAllEmployees(int page, int size, String sortBy) {
	        Sort sort = Sort.by(sortBy).ascending();
	        Pageable pageable = PageRequest.of(page, size, sort);
	        Page<Employee> employeePage = employeeRepository.findAll(pageable);
	        return employeePage.getContent();
	    }
	    
	    
	    
}
