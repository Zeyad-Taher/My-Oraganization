package com.ntg.organization.organization.controller;

import java.util.List;

import com.ntg.organization.organization.validation.EmployeeValidation;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.service.EmployeeService;

@RestController
@RequestMapping("/emp/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeValidation employeeValidation;

	@GetMapping(value = "/all")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping(value = "/getByName&Email/{name}/{email}")
	public ResponseEntity<?> getEmployeeByNameAndEmail(@PathVariable String name, @PathVariable String email) {
		return employeeService.getEmployeeByNameAndEmail(name, email);
	}

	@PostMapping(value = "/add")
	public Employee createNewEmployee(@RequestBody Employee newEmp) {
		return employeeService.createNewEmployee(newEmp);
	}

	@DeleteMapping(value = "/del/{empId}")
	public boolean deleteEmployee(@PathVariable(value = "empId") Long id) {
		return employeeService.deleteEmployeeById(id);
	}

	@PutMapping(value="/assign/{empId}/{depId}")
	public Employee assignDepartment(@PathVariable Long empId,@PathVariable Long depId){
		return employeeService.updateEmployee(empId,depId);
	}
}
