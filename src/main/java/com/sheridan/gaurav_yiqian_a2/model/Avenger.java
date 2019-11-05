/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.model;

import java.io.Serializable;
import com.sheridan.gaurav_yiqian_a2.model.PowerSource;
/**
 *
 * @author tayad
 */
public class Avenger implements Serializable{
    
    private int id;
    private String name,description;
    private PowerSource powerSource;
    private String imgURL;

    public Avenger(int id, String name, String description, PowerSource powerSource,String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
        this.imgURL = imgURL;
    }
    
    public Avenger(String name, String desciption,PowerSource powerSource, String imgURL){
        this.name = name;
        this.description = desciption;
        this.powerSource = powerSource;
        this.imgURL = imgURL;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
    
}
