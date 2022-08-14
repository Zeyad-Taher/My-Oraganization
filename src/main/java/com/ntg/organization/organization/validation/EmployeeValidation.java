package com.ntg.organization.organization.validation;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.exception.ErrorResponse;
import com.ntg.organization.organization.exception.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {
    public ResponseEntity<?> getEmployeeByNameAndEmail(Employee employee) {
        if(employee == null){
            return new ResponseEntity<>(new ErrorResponse(Errors.EMPLOYEE_NOT_FOUND.getCode(),
                    Errors.EMPLOYEE_NOT_FOUND.getMessage()),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
