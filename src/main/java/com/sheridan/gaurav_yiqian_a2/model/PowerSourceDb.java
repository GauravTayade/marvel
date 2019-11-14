/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/

package com.sheridan.gaurav_yiqian_a2.model;

import com.sheridan.gaurav_yiqian_a2.database.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author tayad
 */
public class PowerSourceDb {

    private ArrayList<PowerSource> powerSourceList = new ArrayList<>();
    private PowerSource powerSource;
    Db db = new Db();
    
//    public ResultSet dbQuery(String queryString){
//        
//        String driver = "org.postgresql.Driver";
//        String connURL = "jdbc:postgresql://localhost/MyDb";
//        String username ="postgres";
//        String password =  "root";
//        Connection conn = null;
//        String query = queryString;
//        ResultSet rs = null;
//      
//        try{   
//            Class.forName(driver).newInstance();
//            conn = DriverManager.getConnection(connURL,username,password);
//            Statement stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//       
//      return rs;
//    }
        
    public PowerSource getPowerSource(int id){
        
        Connection sqlconConnection = db.getConnection();
        ResultSet resultSetPowerSource;
        
        try{
        String getPowerSourcesQuery = "SELECT * FROM powersource where id=?";
        PreparedStatement statement = sqlconConnection.prepareStatement(getPowerSourcesQuery);
        statement.setInt(1, id);
        
        resultSetPowerSource = statement.executeQuery();
        
            while(resultSetPowerSource.next()){
                powerSource = new PowerSource(resultSetPowerSource.getInt("id"),resultSetPowerSource.getString("description"));
            }
        }catch(SQLException sqlex){
            System.out.println(sqlex.toString());
        }
        
        return powerSource;
    }
    
    public ArrayList<PowerSource> getPowerSources(){
        
        Connection sqlconnection = db.getConnection();
        ResultSet resultSetPowerSources;
        
        try{
            String getPowerSourcesQuery = "SELECT * FROM powersource";
            PreparedStatement statement = sqlconnection.prepareStatement(getPowerSourcesQuery);
            
            resultSetPowerSources = statement.executeQuery();
        
            while(resultSetPowerSources.next()){
                powerSourceList.add(new PowerSource(resultSetPowerSources.getInt(1),resultSetPowerSources.getString(2)));
            }
        }catch(SQLException sqlex){
            System.out.println(sqlex.toString());
        }
        return powerSourceList;
    }
    
}
