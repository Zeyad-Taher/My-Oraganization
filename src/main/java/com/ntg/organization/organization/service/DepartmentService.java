package com.ntg.organization.organization.service;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.dto.EmployeeDTO;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.DepartmentRepository;
import com.ntg.organization.organization.validation.DepartmentValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentValidation departmentValidation;

	public List<DepartmentDTO> getAllDepartment() {
		List<Department> departments = (List<Department>) departmentRepository.findAll();
		List<DepartmentDTO> deptDTOList = null;

		if(!departments.isEmpty()) {
			deptDTOList = new ArrayList<>();
			DepartmentDTO deptDto = null;
			for (Department department : departments) {
				deptDto = new DepartmentDTO();
				BeanUtils.copyProperties(department, deptDto);
				deptDTOList.add(deptDto);
			}
		}

		return deptDTOList;
	}

	public Department createNewDepartment(Department newDep) {
		if (newDep != null) {
			return departmentRepository.save(newDep);
		}
		return null;
	}

	public boolean deleteDepartmentById(Long id) {
		if (id != null) {
			departmentRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public ResponseEntity<?> getDepartmentByName(String name) {
		Department department = departmentRepository.findByDeptName(name);
		return departmentValidation.getDepartmentByName(department);
	}

	public Department getDepartmentById(Long depId) {
		return departmentRepository.findById(depId).orElse(null);
	}

	public List<EmployeeDTO> getEmployees(String depName) {
		List<Employee> empList = departmentRepository.findByDeptName(depName).getEmployees();
		List<EmployeeDTO> empDTOList = null;

		if(!empList.isEmpty()) {
			empDTOList = new ArrayList<>();
			EmployeeDTO empDto = null;
			for (Employee employee : empList) {
				empDto = new EmployeeDTO();
				BeanUtils.copyProperties(employee, empDto);
				empDTOList.add(empDto);
			}
		}
		return empDTOList;
	}
}
