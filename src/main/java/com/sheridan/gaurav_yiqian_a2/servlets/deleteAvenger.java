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
import com.sheridan.gaurav_yiqian_a2.model.Avenger;
import java.io.File;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import org.json.JSONObject;


/**
 *
 * @author tayad
 */
public class deleteAvenger extends HttpServlet {

    int avengerId;
    AvengerDb avengerdb = new AvengerDb();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        //get servlet context
        ServletContext context = request.getServletContext();
        
        try{
        
            //if paramter is not empty
           if(!request.getParameter("id").isEmpty()){
                //parse parameter from string to integer
                avengerId = Integer.parseInt(request.getParameter("id"));
                log(request.getParameter("id"));
                //get avemger from database
                Avenger avengerDelete = avengerdb.getAvenger(avengerId);
                int result = avengerdb.removeAvenger(avengerId);
                log(Integer.toString(result));
                
                //if recorf deleted
                if(result>0){
                    
                        //image path creation to delete the image from disk
                        String path  = getServletContext().getRealPath("/");
                        context.log(path);
                        //File file1 = new File(path).getParentFile().getParentFile();
                        File file1 = new File(path);
                        //File file= new File(file1,"src/main/webapp/"+avengerDelete.getImgURL());
                        File file= new File(file1,avengerDelete.getImgURL());
                        context.log("file1 value: "+file1.getPath());
                        context.log("file value: "+file.getPath());
                        //check if the image file is deleted
                        if(file.delete()){
                            
                            context.log("iamge successfully Deleted");
                        }else{
                            context.log("Failed to delete image");
                        }
                }
                
                //create json object and send the result back as json object
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                JSONObject json = new JSONObject();
                json.append("result", result);
                out.print(json.toString());
            }
        }catch(Exception ex){
            throw new ServletException(ex.toString());
       } 
   } 
}
