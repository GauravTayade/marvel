/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

package com.sheridan.gaurav_yiqian_a2.taghandlers;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sheridan.gaurav_yiqian_a2.model.PowerSourceDb;
import com.sheridan.gaurav_yiqian_a2.model.PowerSource;
import java.util.ArrayList;

/**
 *
 * @author tayad
 */
public class PowerSourceHandler extends SimpleTagSupport{

    PowerSourceDb powersource = new PowerSourceDb();
    //list to store all fatched powersoruces in the list
    ArrayList<PowerSource> powerSourceList = new ArrayList<>();
    private int avengerPowerSourceId;

    public int getAvengerPowerSourceId() {
        return avengerPowerSourceId;
    }

    public void setAvengerPowerSourceId(int avengerPowerSourceId) {
        this.avengerPowerSourceId = avengerPowerSourceId;
    }
        
    @Override
    public void doTag() throws JspException, IOException {
           
        //clear list before loading with powersources
        powerSourceList.clear();
        
        try{
            //get the list of powersoruces
            powerSourceList = powersource.getPowerSources();
        
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        JspWriter out = getJspContext().getOut();
        
        try{
            JspFragment f = getJspBody();
            if(f!=null){
                f.invoke(out);
            }
            
            //setting select list as output using jsp writer
            out.println("<select class=\"form-control\" name=\"powerSource\" required>");
            out.println("<option value=\"\">Select Powersource</option>");
            for (PowerSource powerSource : powerSourceList) {
                //check if the powersource id matches with the any existing 
                //record to make it selected on edit page
                if(this.getAvengerPowerSourceId() == powerSource.getId()){
                    out.println("<option value="+powerSource.getId()+" selected>"
                            +powerSource.getDescription()+"</option>");
                }else{
                    out.println("<option value="+powerSource.getId()+">"
                            +powerSource.getDescription()+"</option>");
                }
            }
            
            out.println("</select>");
            
        }catch(java.io.IOException ioex){
            
            throw new JspException("error in powersource tag"+ioex.toString());
        
        }
        
    }
    
}
