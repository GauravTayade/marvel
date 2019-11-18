/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.model;

import javax.servlet.http.HttpSession;

/**
 *
 * @author tayad
 */
public class User {
    
    private String username,firstname,lastname,email;

    //default constructor
    public User() {
    }
    
    //parameterized constructor for user.
    public User(String firstname, String lastname, String username, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //method to get full name of the user
    public String getFullname(){
        return this.getFirstname()+" "+this.getLastname();
    }
    
}
