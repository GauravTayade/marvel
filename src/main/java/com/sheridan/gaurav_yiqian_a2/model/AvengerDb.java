/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tayad
 */
public class AvengerDb {
    
    PowerSourceDb pwsDb = new PowerSourceDb();
    
    public Connection sqlconnection(){
    
        String driver = "org.postgresql.Driver";
        String connURL = "jdbc:postgresql://localhost/MyDb";
        String username ="postgres";
        String password =  "root";
        Connection conn = null;
        
         try{
            Class.forName(driver).newInstance();
        
            conn = DriverManager.getConnection(connURL,username,password);
        }catch(Exception ex){
             System.out.println("ex"+ex);
        }
    
         return conn;
    }
    
    public ResultSet dbQuery(String queryString){
        
        Connection sqlconnection = this.sqlconnection();
        String query = queryString;
        ResultSet rs = null;
               System.out.println(query);
        try{
            Statement stmt = sqlconnection.createStatement();
            rs = stmt.executeQuery(query);
        }catch(SQLException sqlex){
            System.out.println(sqlex);
        }
      return rs;
    }
    
    private ArrayList<Avenger> avengersList = new ArrayList<>();
    
    public int addAvenger(Avenger avenger){
    
        int result = 0;
        String insertQuery =  "INSERT INTO avengers (\"avengername\",\"description\",\"powersource\",\"img\") "
                        + "VALUES ('"+avenger.getName()+"',"
                        + "'"+avenger.getDescription()+"',"
                        + "'"+avenger.getPowerSource().getId()+"',"
                        + "'"+avenger.getImgURL()+"')";
        
        Connection sqlconnection = this.sqlconnection();
        try{
            System.out.println(insertQuery);
            Statement statement = sqlconnection.createStatement();
            result = statement.executeUpdate(insertQuery);
        }catch(SQLException sqlex){
        
        }
        
        return result;
    }
    
    public int removeAvenger(int id){
        
        int result=0 ;
        Connection conn = this.sqlconnection();
        PreparedStatement prestatment=null;
        
        try{
            String removeAvengersQuery = "DELETE FROM avengers Where id="+id;
            prestatment = conn.prepareStatement(removeAvengersQuery);
            
            System.out.println(removeAvengersQuery);

            result = prestatment.executeUpdate();
        }catch(SQLException sqlex){
            System.out.println(sqlex);
        }
        
        return result;
    }
    
    public ArrayList<Avenger> getAvengers(){
    
        String getAvengersQuery = "SELECT * FROM avengers";
        ResultSet resultSetAvengers = this.dbQuery(getAvengersQuery);
        avengersList.clear();
        try{
            while(resultSetAvengers.next()){
                
                PowerSource avengerPowerSource = pwsDb.getPowerSource(resultSetAvengers.getInt(4));
                avengersList.add(new Avenger(resultSetAvengers.getInt(1),resultSetAvengers.getString(2),resultSetAvengers.getString(3),avengerPowerSource,resultSetAvengers.getString(5)));
            }
        }catch(SQLException sqlex){
        
        }
        
        return avengersList;
    
    }
    
}
