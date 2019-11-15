package com.sheridan.gaurav_yiqian_a2.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

import com.sheridan.gaurav_yiqian_a2.model.Avenger;
import com.sheridan.gaurav_yiqian_a2.model.AvengerDb;
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
public class UpdateAvenger extends HttpServlet {

    int avengerUpdateId;
    AvengerDb avengerDb = new AvengerDb();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        
            boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
            String imageUrl=null;
            String uploadPath;
            HashMap<String, String> fieldsHash = new HashMap<>();
            
            PowerSource powersource = new PowerSource();
            PowerSourceDb powerSourceDb = new PowerSourceDb();
            
            if(isMultipartContent){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            try{
                List<FileItem> fields = upload.parseRequest(request);
                Iterator<FileItem> it = fields.iterator();
                                
                while(it.hasNext()){
                    FileItem fileItem = it.next();
                    if (fileItem.isFormField()) {
                        fieldsHash.put(fileItem.getFieldName(), fileItem.getString());
                    } else {
                        
                        //Code to check if the directory exists                        
                        String path  = getServletContext().getRealPath("/");
                        
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
                        uploadPath = file1.getPath()+"\\src\\main\\webapp\\resources\\images\\heros-profile\\"+fileItem.getName();
                        
                        //get avenger
                        avengerUpdateId = Integer.parseInt(fieldsHash.get("avengerUpdateId"));
                        Avenger checkAvengerImage = avengerDb.getAvenger(avengerUpdateId);
                        
                        context.log(Boolean.toString(fieldsHash.containsKey("avengerImage")));
                        context.log(fileItem.getName());
                        if(fileItem.getName() == null || fileItem.getName().equals("")){
                            imageUrl = checkAvengerImage.getImgURL();
                        }else{
                            imageUrl = "resources\\images\\heros-profile\\"+fileItem.getName();
                            try{
                                fileItem.write(new File(uploadPath));
                            }catch(Exception flx){
                                context.log(flx.toString());
                            }
                        }
                        
                    }
                }
                
                
                    
                try{
                    powersource = powerSourceDb.getPowerSource(Integer.parseInt(fieldsHash.get("powerSource")));
                    context.log(powersource.getDescription());
        
                    Avenger avenger = new Avenger(fieldsHash.get("avengerName"), fieldsHash.get("avengerDescription"), powersource, imageUrl);
                    if(avengerDb.updateAvenger(avenger,avengerUpdateId) >  0){
                        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                        rd.forward(request, response);
                    }else{
                        context.log("failed");
                    }
                
                }catch(Exception ex){
               
                context.log(ex.toString());
                
                }
            }catch(Exception ex){
                context.log(ex.toString());
            }
            }
        
    }
}
