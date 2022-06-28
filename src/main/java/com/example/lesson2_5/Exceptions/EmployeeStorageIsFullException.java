package com.example.lesson2_5.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException ( ){
        super();
    }
}
