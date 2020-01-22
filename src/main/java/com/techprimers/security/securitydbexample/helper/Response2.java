package com.techprimers.security.securitydbexample.helper;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data

public class Response2 {

    public   String message;
    public  boolean valid;
    public  String description;
    public  int statusCode;
    public  Object objectResponse;
    public  List<Object> mainResponse;
    public HttpStatus errorCode;
    public String errorMessage;

    public Response2(String message) {
        this.message = message;
        this.statusCode = 200;
        this.mainResponse = null;
        this.valid = true;
        this.errorCode = HttpStatus.OK;
    }
    public Response2() {
 
    }
    public Response2(String errorMessage, HttpStatus errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        
    }
}