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
    ArrayList<PowerSource> powerSourceList = new ArrayList<>();
    
    @Override
    public void doTag() throws JspException, IOException {
        
        powerSourceList.clear();
        powerSourceList = powersource.getPowerSources();
        
        JspWriter out = getJspContext().getOut();
        
        try{
            JspFragment f = getJspBody();
            if(f!=null){
                f.invoke(out);
            }
            out.println("<select class=\"form-control\" name=\"powerSource\">");
            out.println("<option value=\"\">Select Powersource</option>");
            for (PowerSource powerSource : powerSourceList) {
                out.println("<option value="+powerSource.getId()+">"+powerSource.getDescription()+"</option>");
            }
            out.println("</select>");
        }catch(java.io.IOException ioex){
            throw new JspException("error in powersource tag"+ioex.toString());
        }
        
    }
    
}
