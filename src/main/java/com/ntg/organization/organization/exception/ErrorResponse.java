package com.ntg.organization.organization.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
}
