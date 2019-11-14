/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheridan.gaurav_yiqian_a2.model.Avenger;
import com.sheridan.gaurav_yiqian_a2.model.AvengerDb;
import com.sheridan.gaurav_yiqian_a2.model.PowerSource;
import com.sheridan.gaurav_yiqian_a2.model.PowerSourceDb;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author tayad
 */
public class EditAvenger extends HttpServlet {

    int avengerId;
    ServletContext context;
    AvengerDb avengerDb = new AvengerDb();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getParameterMap().containsKey("avengerUpdateId")){
            avengerId = Integer.parseInt(request.getParameter("avengerId"));
            context = request.getServletContext();
            context.log(request.getParameter("avengerId"));
        
            Avenger avenger = avengerDb.getAvenger(avengerId);
        
            request.setAttribute("AvengerDetail", avenger);
            RequestDispatcher rd = request.getRequestDispatcher("editAvenger.jsp");
            rd.forward(request, response);
        }else{
            
        }
    }

}
