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
        
        String driver = "org.postgresql.Driver";
        String connURL = "jdbc:postgresql://localhost/MyDb";
        String username ="postgres";
        String password =  "root";
        Connection conn = null;
        String query = queryString;
        ResultSet rs = null;
      
        try{   
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(connURL,username,password);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }catch(Exception ex){
            System.out.println(ex);
        }
       
      return rs;
    }
        
    public PowerSource getPowerSource(int id){
    
        String getPowerSourcesQuery = "SELECT * FROM powersource where id="+id;
        System.out.println(getPowerSourcesQuery);
        ResultSet resultSetPowerSource = dbQuery(getPowerSourcesQuery);
        System.out.println(resultSetPowerSource);
        try{
            while(resultSetPowerSource.next()){
                powerSource = new PowerSource(resultSetPowerSource.getInt("id"),resultSetPowerSource.getString("description"));
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
