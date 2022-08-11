package com.ntg.organization.organization.controller;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep/v1")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

//	@GetMapping(value = "/all")
//	public List<Department> getAllDepartment() {
//		return departmentService.getAllDepartment();
//	}

	@GetMapping(value="/all")
	public List<DepartmentDTO> getAllDepartment(){
		return departmentService.getAllDepartment();
	}

	@GetMapping(value = "/getByName/{name}")
	public Department getDepartmentByName(@PathVariable String name) {
		return departmentService.getDepartmentByName(name);
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
