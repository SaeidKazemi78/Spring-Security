package com.techprimers.security.securitydbexample.controller;

import com.techprimers.security.securitydbexample.helper.Response2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {

    @RequestMapping("/")
    public Response2 delete() {

        return new Response2("Here is home page");
    }

}