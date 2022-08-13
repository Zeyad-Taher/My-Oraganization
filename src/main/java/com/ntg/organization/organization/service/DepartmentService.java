package com.ntg.organization.organization.service;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<DepartmentDTO> getAllDepartment() {
		List<Department> depts = (List<Department>) departmentRepository.findAll();
		List<DepartmentDTO> deptDTOList = null;

		if(!depts.isEmpty()) {
			deptDTOList = new ArrayList<>();
			DepartmentDTO deptDto = null;
			for (Department department : depts) {
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

	public DepartmentDTO getDepartmentByName(String name) {
		Department department = departmentRepository.findByDeptName(name);
		DepartmentDTO departmentDto = null;
		if(department != null) {
			departmentDto=new DepartmentDTO();
			BeanUtils.copyProperties(department, departmentDto);
		}
		return departmentDto;
	}

	public Department getDepartmentById(Long depId) {
		return departmentRepository.findById(depId).orElse(null);
	}

	public List<Employee> getEmployees(String depName) {
		return departmentRepository.findByDeptName(depName).getEmployees();
	}
}
