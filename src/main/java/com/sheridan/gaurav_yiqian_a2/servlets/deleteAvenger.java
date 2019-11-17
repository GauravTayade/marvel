/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sheridan.gaurav_yiqian_a2.model.AvengerDb;
import java.sql.SQLException;


/**
 *
 * @author tayad
 */
public class deleteAvenger extends HttpServlet {

    int avengerId;
    AvengerDb avengerdb = new AvengerDb();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       try{
        
           if(!request.getParameter("id").isEmpty()){
                avengerId = Integer.parseInt(request.getParameter("id"));
                log(request.getParameter("id"));
                int result = avengerdb.removeAvenger(avengerId);
                log(Integer.toString(result));
           
            }
        }catch(Exception ex){
            throw new ServletException(ex.toString());
       } 
   } 
}
