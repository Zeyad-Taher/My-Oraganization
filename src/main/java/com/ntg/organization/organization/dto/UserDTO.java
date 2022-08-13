package com.ntg.organization.organization.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserDTO {
    private Long id;
    private String userName;
    private String password;
}
