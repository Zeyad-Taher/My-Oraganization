package com.ntg.organization.organization.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
}