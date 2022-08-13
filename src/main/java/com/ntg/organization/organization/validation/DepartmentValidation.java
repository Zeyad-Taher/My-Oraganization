package com.ntg.organization.organization.validation;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.exception.ErrorResponse;
import com.ntg.organization.organization.exception.Errors;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentValidation {

    public ResponseEntity<?> getDepartmentByName(Department department) {
        DepartmentDTO departmentDto = null;
        if(department != null) {
            departmentDto=new DepartmentDTO();
            BeanUtils.copyProperties(department, departmentDto);
            return new ResponseEntity<>(departmentDto,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ErrorResponse(Errors.DEPARTMENT_NOT_FOUND.getCode(),
                    Errors.DEPARTMENT_NOT_FOUND.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
