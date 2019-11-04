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
public class AvengerDb {
    
    PowerSourceDb pwsDb = new PowerSourceDb();
    
    public Connection sqlconnection(){
    
        String driver = "org.postgres.Driver";
        String connURL = "jdbc:postgresql://loclahost/MyDb";
        String username ="postgres";
        String password =  "root";
        Connection conn = null;
        
         try{
            Class.forName(driver).newInstance();
        
            conn = DriverManager.getConnection(connURL,username,password);
        }catch(Exception ex){
        
        }
    
         return conn;
    }
    
    public ResultSet dbQuery(String queryString){
        
        Connection sqlconnection = this.sqlconnection();
        String query = queryString;
        ResultSet rs = null;
               
        try{
            Statement stmt = sqlconnection.createStatement();
            rs = stmt.executeQuery(query);
        }catch(SQLException sqlex){
        
        }
      return rs;
    }
    
    private ArrayList<Avenger> avengersList = new ArrayList<>();
    
    public int addAvenger(Avenger avenger){
    
        String insertQuery =  "INSERT INTO avengers (\"\",\"bookauthour\",\"bookyear\",\"bookprice\",\"bookrating\",\"bookstatus\") "
                        + "VALUES ('"+txtBookTitle.getText()+"',"
                        + "'"+txtBookAuthour.getText()+"',"
                        + "'"+txtBookYear.getText()+"',"
                        + ""+Float.parseFloat(txtBookPrice.getText())+","
                        + "'"+txtBookRating.getText()+"',"
                        + ""+Integer.parseInt(txtBookStatus.getText())+");";
        Connection sqlconnection = this.sqlconnection();
        Statement statement = sqlconnection.createStatement();
        return statement.executeUpdate(query);
    }
    
    public ArrayList<Avenger> getAvengers(){
    
        String getAvengersQuery = "SELECT * FROM avengers";
        ResultSet resultSetAvengers = this.dbQuery(getAvengersQuery);
        
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
