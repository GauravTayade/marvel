/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.servlets;

import com.sheridan.gaurav_yiqian_a2.model.AvengerDb;
import com.sheridan.gaurav_yiqian_a2.model.Avenger;
import com.sheridan.gaurav_yiqian_a2.model.PowerSource;
import com.sheridan.gaurav_yiqian_a2.model.PowerSourceDb;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author tayad
 */
@MultipartConfig
public class AddAvenger extends HttpServlet {
   
    String name,description,imgURL,uploadPath;
    PowerSource powersource;
    
    AvengerDb avengerdb = new AvengerDb();
    HashMap<String, String> fieldsHash = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        String imageUrl=null;
        
        if(isMultipartContent){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            try{
                List<FileItem> fields = upload.parseRequest(request);
                Iterator<FileItem> it = fields.iterator();
                
//                ServletContext context = request.getServletContext();
//                File file = new File(".");
//                context.log(file.getCanonicalPath());
                
                while(it.hasNext()){
                    FileItem fileItem = it.next();
                    if (fileItem.isFormField()) {
                        fieldsHash.put(fileItem.getFieldName(), fileItem.getString());
                    } else {
                        
                        //Code to check if the directory exists                        
                        String path  = getServletContext().getRealPath("/");
                        ServletContext context = request.getServletContext();
                        context.log(path);
                        File file1 = new File(path).getParentFile().getParentFile();
                        File file= new File(file1,"/uploads//");
                        
                        context.log("new path after change:"+file.getPath()+"\\");
                        if(!file.isDirectory()){
                            context.log("directory does not exists");
                            file.mkdir();
                            context.log("directory created");
                        }
                        
                        //uploadPath = "D:\\Sheridan\\Semester-3\\Enterprise JAVA\\Assignments\\Assignment-2\\gaurav_yiqian_a2\\src\\main\\webapp\\resources\\images\\heros-profile\\"+ fileItem.getName();
                        //imageUrl="resources\\images\\heros-profile\\"+ fileItem.getName();
                        uploadPath = file.getPath()+"\\src\\main\\webapp\\resources\\images\\heros-profile\\"+fileItem.getName();
                        imageUrl = "resources\\images\\heros-profile\\"+fileItem.getName();
                        
                        try{
                            fileItem.write(new File(uploadPath));
                        }catch(Exception ex){
                            System.out.println(ex);
                        }
                    }
                }
                
            }catch(Exception ex){
            
            }
        }

        //get powersource;
        powersource = new PowerSource();
        PowerSourceDb powerSourceDb = new PowerSourceDb();
        powersource = powerSourceDb.getPowerSource(Integer.parseInt(fieldsHash.get("powerSource")));
        
        Avenger avenger = new Avenger(fieldsHash.get("avengerName"), fieldsHash.get("avengerDescription"), powersource, imageUrl);
        if(avengerdb.addAvenger(avenger) >  0){
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        }
        
    }
}
