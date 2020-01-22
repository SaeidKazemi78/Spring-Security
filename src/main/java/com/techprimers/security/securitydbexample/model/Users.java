package com.techprimers.security.securitydbexample.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tbl_user")
public class Users {

    public Users(UserDto dto){
        this.email=dto.getEmail();
        this.password=dto.getPassword();
        this.username=dto.getUsername();
        this.active=dto.getActive();
        this.lastName=dto.getLastName();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "username")
    public String username;

    
    @Column(name = "last_name")
    public String lastName;
    
    @Column(name = "active")
    public int active;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roles;


    
    public Users() {
    }
    public Users(Users users) {
        this.active = users.getActive();
        this.email = users.getEmail();
        this.roles = users.getRoles();
        this.password=users.getPassword();
        this.username = users.getUserName();
        this.lastName =users.getLastName();
        this.id = users.getId();
        this.password = users.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
