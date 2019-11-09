/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.servlets;

import com.sheridan.gaurav_yiqian_a2.model.Avenger;
import com.sheridan.gaurav_yiqian_a2.model.AvengerDb;
import com.sheridan.gaurav_yiqian_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tayad
 */
public class GetAvengers extends HttpServlet {

    AvengerDb avengersDetails = new AvengerDb();
    PowerSourceDb powerSourceDetails = new PowerSourceDb();

    ArrayList<Avenger> avengersList = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        avengersList = avengersDetails.getAvengers();
        request.setAttribute("avengersList",avengersList);
        System.out.println(avengersList.size());
        RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
        rd.forward(request, response);
        
    }     
}
