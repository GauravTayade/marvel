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
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author tayad
 */
public class UpdateAvenger extends HttpServlet {

    int avengerUpdateId;
    AvengerDb avengerDb = new AvengerDb();
    String extension;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        
            //parsing multipart request to check if it is multipart or not
            boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
            String imageUrl=null;
            String uploadPath;
            //create hashmap to store values
            HashMap<String, String> fieldsHash = new HashMap<>();
            
            PowerSource powersource = new PowerSource();
            PowerSourceDb powerSourceDb = new PowerSourceDb();
            
            // cheeck if the request is multipart
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
                        
                        //createing file uplaod path
                        //File file1 = new File(path).getParentFile().getParentFile();
                        File file1 = new File(path);
                        //File file= new File(file1,"/src/main/webapp/resources/images/heros-profile/");
                        File file = new File(file1,"/resources/images/heros-profile/");
                        context.log("new path after change:"+file.getPath()+"/");
                       
                        if(!file.isDirectory()){
                            context.log("directory does not exists");
                            file.mkdir();
                            context.log("directory created");
                        }
                       
                        uploadPath = file.getPath()+"/"+fileItem.getName();
                        
                        //get avenger
                        avengerUpdateId = Integer.parseInt(fieldsHash.get("avengerUpdateId"));
                        Avenger checkAvengerImage = avengerDb.getAvenger(avengerUpdateId);
                        
                        //check if file upload has a file if yes upload new file and delete old one
                        //else keep the old file
                        if(fileItem.getName() == null || fileItem.getName().equals("")){
                            imageUrl = checkAvengerImage.getImgURL();
                            extension = checkAvengerImage.getExtension();
                        }else{
                            //File deleteFile = new File(file1+"/src/main/webapp/",checkAvengerImage.getImgURL());
                            File deleteFile = new File(file1,checkAvengerImage.getImgURL());
                            if(deleteFile.delete()){
                                context.log("image deleted for updated image");
                            }else{
                                context.log("failed to delete image");
                            }
                            
                            imageUrl = "resources/images/heros-profile/"+fileItem.getName();
                            extension = FilenameUtils.getExtension(fileItem.getName());
                            try{
                                context.log(uploadPath);
                                fileItem.write(new File(uploadPath));
                            }catch(Exception flx){
                                context.log(flx.toString());
                            }
                        }
                        
                    }
                }
                
                
                    
                try{
                    //get the powersource
                    powersource = powerSourceDb.getPowerSource(Integer.parseInt(fieldsHash.get("powerSource")));
                    context.log(powersource.getDescription());
                    
                    //create avenger object
                    Avenger avenger = new Avenger(fieldsHash.get("avengerName"), fieldsHash.get("avengerDescription"), powersource, imageUrl,extension);
                    //check if update success or not
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
