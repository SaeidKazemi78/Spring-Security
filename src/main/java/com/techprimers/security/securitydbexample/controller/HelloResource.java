package com.techprimers.security.securitydbexample.controller;

import com.techprimers.security.securitydbexample.helper.Response2;
import com.techprimers.security.securitydbexample.model.Users;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class HelloResource {

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    // When you call @Secured you should user 'ROLE_' prefix and you can not use
    // spring expression here
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

    @PreAuthorize("hasAnyRole('VIEWER')")
    @GetMapping("/secured/viewer")
    public String doSomething() {
        return "Im Doing something";
    }

    @RequestMapping("/")
    public String getHome() {
        return "here is Home _ 1";
    }

    @RequestMapping("/home")
    public String getHome2() {
        return "here is Home _ 2";
    }

    @Secured("ROLE_VIEWER")
    @RequestMapping("/emp")
    public String getEmployee() {
        return "Here are the all Employees ";
    }


    //This method give us current logged in user
    @RequestMapping("/user-now")
    public Object getUserNow() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof UserDetails) {
            String username = ((UserDetails) user).getUsername();
            return  new Response2(username);
        } else {
            String username = user.toString();
            return new Response2(username);
        }
    }

}
