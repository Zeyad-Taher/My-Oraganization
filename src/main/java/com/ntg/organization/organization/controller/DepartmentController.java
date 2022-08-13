package com.ntg.organization.organization.controller;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.dto.EmployeeDTO;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep/v1")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value="/all")
	public List<DepartmentDTO> getAllDepartment(){
		return departmentService.getAllDepartment();
	}

	@GetMapping(value = "/getByName/{depName}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable String depName) {
		return departmentService.getDepartmentByName(depName);
	}

	@GetMapping(value = "/getEmployees/{depName}")
	public List<EmployeeDTO> getEmployeesInDepartment(@PathVariable String depName){
		return departmentService.getEmployees(depName);
	}

	@PostMapping(value = "/add")
	public Department createNewDepartment(@RequestBody Department newDep) {
		return departmentService.createNewDepartment(newDep);
	}

	@DeleteMapping(value = "/del/{depId}")
	public boolean deleteDepartment(@PathVariable(value = "depId") Long id) {
		return departmentService.deleteDepartmentById(id);
	}

}
