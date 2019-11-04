/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

package com.sheridan.gaurav_yiqian_a2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author tayad
 */
public class PowerSourceDb {

    private ArrayList<PowerSource> powerSourceList = new ArrayList<>();
    private PowerSource powerSource;
    
    public ResultSet dbQuery(String queryString){
        
        String driver = "org.postgres.Driver";
        String connURL = "jdbc:postgresql://loclahost/MyDb";
        String username ="postgres";
        String password =  "root";
        Connection conn = null;
        String query = queryString;
        ResultSet rs = null;
        
        try{
            Class.forName(driver).newInstance();
        
            conn = DriverManager.getConnection(connURL,username,password);
        }catch(Exception ex){
        
        }
        
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }catch(SQLException sqlex){
        
        }
      return rs;
    }
        
    public PowerSource getPowerSource(int id){
    
        String getPowerSourcesQuery = "SELECT * FROM powersource where id="+id;
        ResultSet resultSetPowerSource = this.dbQuery(getPowerSourcesQuery);
        
        try{
            while(resultSetPowerSource.next()){
                powerSource = new PowerSource(resultSetPowerSource.getInt(1),resultSetPowerSource.getString(2));
            }
        }catch(SQLException sqlex){
        
        }
        
        return powerSource;
    }
    
    public ArrayList<PowerSource> getPowerSources(){
        
        String getPowerSourcesQuery = "SELECT * FROM powersource";
        ResultSet resultSetPowerSources = this.dbQuery(getPowerSourcesQuery);
        
        try{
            while(resultSetPowerSources.next()){
                powerSourceList.add(new PowerSource(resultSetPowerSources.getInt(1),resultSetPowerSources.getString(2)));
            }
        }catch(SQLException sqlex){
        
        }
        return powerSourceList;
    }
    
}
