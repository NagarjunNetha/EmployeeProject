package com.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import com.app.service.EmailService;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/users")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmailService emailService;

	public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService,
			EmailService emailService) {
		this.employeeRepository = employeeRepository;
		this.employeeService = employeeService;
		this.emailService = emailService;
	}

	@PostMapping
	String addEmployee(@RequestBody Employee employee) {

		employee.setId(UUID.randomUUID().toString());
		employeeRepository.save(employee);

		String managerId = employee.getReportsTo();
		Employee manager = employeeRepository.findById(managerId).orElse(null);

		emailService.sendNewEmployeeEmail(employee, manager);
		return employee.getId();

	}

	@GetMapping
	public List<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "employeeName") String sortBy) {
		return employeeService.getAllEmployees(page, size, sortBy);
	}

	@GetMapping("/{employeeId}/manager/{level}")
	public Employee getNthLevelManager(@PathVariable String employeeId, @PathVariable int level) {
		return employeeService.getNthLevelManager(employeeId, level);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable String id) {

		employeeRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable String id, @RequestBody Employee employee) {

		employee.setId(id);
		employeeRepository.save(employee);
		return id;
	}

}
