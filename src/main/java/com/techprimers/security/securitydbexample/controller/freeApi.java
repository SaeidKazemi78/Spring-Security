package com.techprimers.security.securitydbexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/free")
public class freeApi {

    
    @RequestMapping("/get-free")
    public String get1(){
        return "redirect:/logout";
    }
    
    @RequestMapping("/another-free")
    public String get2(){

        return "Here is second free Api";
    }


    @RequestMapping("/third-free")
    public String get3(){
        return "Here is third  free Api";
    }


    @RequestMapping("/user")
    public String getUser() {
        return "Here are the all Users ";
    }

}