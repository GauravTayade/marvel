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

/**
 *
 * @author tayad
 */
public class UserLogout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get the current session
        HttpSession userSession = request.getSession(false);
        //destroy user session and redirect to index.jsp
        if(userSession.getAttribute("user")!=null || userSession.getAttribute("user").equals("")){
            userSession.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}
