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
import org.apache.commons.io.FilenameUtils;
/**
 *
 * @author tayad
 */
@MultipartConfig
public class AddAvenger extends HttpServlet {
   
    String name,description,imgURL,uploadPath,extension;
    PowerSource powersource;
    
    AvengerDb avengerdb = new AvengerDb();
    //create hash to store values
    HashMap<String, String> fieldsHash = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
        //parsing multipart request to check if it is multipart or not
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        String imageUrl=null;
        //get servlet context to log
        ServletContext context = request.getServletContext();
        
        if(isMultipartContent){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            try{
                List<FileItem> fields = upload.parseRequest(request);                
                Iterator<FileItem> it = fields.iterator();
                context.log("it value: "+it.hasNext());
                //loop to check if iterator has value
                while(it.hasNext()){
                    FileItem fileItem = it.next();
                        if(fileItem.getSize() == 0){
                            request.setAttribute("error","Please fill all the inputs");
                            RequestDispatcher rd = request.getRequestDispatcher("addAvenger.jsp");
                            rd.forward(request, response);
                            return;
                        }
                        
                    //check if the value is form field
                    if (fileItem.isFormField()) {
                        fieldsHash.put(fileItem.getFieldName(), fileItem.getString());
                    } else {
                        
                        //Code to check if the directory exists                        
                        String path  = getServletContext().getRealPath("/");
                        
                        context.log(path);
                        
                        //create file upload path
                        File file1 = new File(path).getParentFile().getParentFile();
                        //File file1 = new File(path);
                        //File file= new File(file1,"/src/main/webapp/resources/images/heros-profile/");
                        File file = new File(file1,"/resources/images/heros-profile/");
                        context.log("new path after change:"+file.getPath());
                        
                        //create directory of does not exits
                        if(!file.isDirectory()){
                            context.log("directory does not exists");
                            file.mkdir();
                            context.log("directory created");
                        }
                        
                        //uploadPath = "D:\\Sheridan\\Semester-3\\Enterprise JAVA\\Assignments\\Assignment-2\\gaurav_yiqian_a2\\src\\main\\webapp\\resources\\images\\heros-profile\\"+ fileItem.getName();
                        //imageUrl="resources\\images\\heros-profile\\"+ fileItem.getName();
                        uploadPath = file1.getPath()+"/src/main/webapp/resources/images/heros-profile/"+fileItem.getName();
                        //uploadPath = file1.getPath()+"/resources/images/heros-profile/"+fileItem.getName();
                        imageUrl = "resources/images/heros-profile/"+fileItem.getName();
                        extension = FilenameUtils.getExtension(fileItem.getName());
                        context.log(extension);
                        context.log(uploadPath);
                        //upload image to directory
                        try{
                            fileItem.write(new File(uploadPath));
                        }catch(Exception ex){
                           context.log(ex.toString());
                        }
                    }
                }
                
            }catch(Exception ex){
                context.log(ex.toString());
            }
        }
        context.log("worked");
        //get powersource;
        try{
            powersource = new PowerSource();
            PowerSourceDb powerSourceDb = new PowerSourceDb();
            powersource = powerSourceDb.getPowerSource(Integer.parseInt(fieldsHash.get("powerSource")));
            context.log(powersource.getDescription());
        
            //create a avenger object and call to add method to add avenger in database
            Avenger avenger = new Avenger(fieldsHash.get("avengerName"), 
                fieldsHash.get("avengerDescription"), powersource, imageUrl,extension);
            //if isnert success 
            if(avengerdb.addAvenger(avenger) >  0){
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request, response);
            }else{
                context.log("failed");
            }
        }catch(Exception ex){
            context.log(ex.toString());
        }
        
    }
}
