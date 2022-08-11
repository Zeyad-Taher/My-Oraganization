package com.ntg.organization.organization.service;

import java.util.List;

import com.ntg.organization.organization.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentService departmentService;

	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee createNewEmployee(Employee newEmp) {
		if (newEmp != null) {
			return employeeRepository.save(newEmp);
		}
		return null;
	}

	public boolean deleteEmployeeById(Long id) {
		if (id != null) {
			employeeRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Employee getEmployeeByName(String name, String email) {
		return employeeRepository.findByNameAndEmail(name, email);
	}

	public Employee updateEmployee(Long empId, Long depId) {
		Employee employee=employeeRepository.findById(empId).orElse(null);
		Department department=departmentService.getDepartmentById(depId);
		if(employee!=null && department!=null){
			employee.setDepartment(department);
			return employeeRepository.save(employee);
		}
		else
			return null;
	}
}
