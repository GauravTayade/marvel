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
    
    private String username;

    public User() {
    }
    
    public User(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public boolean loginCheck(String username, String password){
        boolean isLogin = false;
            if(username.equalsIgnoreCase("gaurav") && password.equalsIgnoreCase("gaurav2012"))
            {
                isLogin = true;
            }
         return isLogin;
    }
    
}
