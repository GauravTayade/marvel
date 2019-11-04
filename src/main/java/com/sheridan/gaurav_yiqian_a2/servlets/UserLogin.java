/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheridan.gaurav_yiqian_a2.model.User;

/**
 *
 * @author tayad
 */
public class UserLogin extends HttpServlet {

    private String username,password;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        if(!username.isEmpty() && !password.isEmpty()){
            User user = new User();
            boolean result = user.loginCheck(username, password);
            
            if(result == true){
                
                HttpSession userSession = request.getSession(false);
                if (userSession.getAttribute("user") == null || userSession.getAttribute("user").equals("")){
                    userSession.setAttribute("user",new User(username));
                }
                
            }
            response.setContentType("text/json:charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(result);
        }
                
    }

}
