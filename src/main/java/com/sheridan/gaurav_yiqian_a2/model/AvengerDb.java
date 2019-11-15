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
public class AvengerDb {
    
    PowerSourceDb pwsDb = new PowerSourceDb();
    Db db = new Db();
       
    private ArrayList<Avenger> avengersList = new ArrayList<>();
    
    public int addAvenger(Avenger avenger) throws Exception{
    
        int result = 0;
        
        String insertQuery = "INSERT INTO avengers (\"avengername\",\"description\",\"powersource\",\"img\")"
                +"VALUES(?,?,?,?)"; 
        Connection sqlconnection = db.getConnection();
        try{
            PreparedStatement statement = sqlconnection.prepareStatement(insertQuery);
            statement.setString(1,avenger.getName());
            statement.setString(2,avenger.getDescription());
            statement.setInt(3,avenger.getPowerSource().getId());
            statement.setString(4,avenger.getImgURL());
            
            result = statement.executeUpdate();
            
        }catch(SQLException sqlex){
            System.out.println(sqlex.toString());
        }
        
        return result;
    }
    
    public int removeAvenger(int id) throws Exception{
        
        int result=0 ;
        Connection sqlconnection = db.getConnection();
        PreparedStatement statment=null;
        
        try{
            String removeAvengersQuery = "DELETE FROM avengers Where id=?";
            statment = sqlconnection.prepareStatement(removeAvengersQuery);
            statment.setInt(1, id);
 
            result = statment.executeUpdate();
 
        }catch(SQLException sqlex){
        
            System.out.println(sqlex);
        
        }
        
        return result;
    }
    
    public ArrayList<Avenger> getAvengers() throws Exception{
    
        Connection sqlconnection = db.getConnection();
        ResultSet resultSetAvengers=null;
                
        String getAvengersQuery = "SELECT * FROM avengers";
        try{
            PreparedStatement statement = sqlconnection.prepareStatement(getAvengersQuery);        
            resultSetAvengers = statement.executeQuery();
            
            avengersList.clear();
            
            while(resultSetAvengers.next()){
                
                PowerSource avengerPowerSource = pwsDb.getPowerSource(resultSetAvengers.getInt(4));
                avengersList.add(new Avenger(resultSetAvengers.getInt(1),resultSetAvengers.getString(2),resultSetAvengers.getString(3),avengerPowerSource,resultSetAvengers.getString(5)));
            }
        }catch(SQLException sqlex){
            System.out.println(sqlex.toString());
        }    
          
        return avengersList;
    
    }
    
    public Avenger getAvenger(int avengerId) throws Exception{
   
        Connection sqlconConnection = db.getConnection();
        Avenger avenger = null;
        ResultSet resultSetAvenger;
                
        try{
            String getAvengerQuery = "SELECT * FROM avengers where id=?";
            PreparedStatement statement = sqlconConnection.prepareStatement(getAvengerQuery);
            statement.setInt(1,avengerId);
        
            resultSetAvenger = statement.executeQuery();
        
            while(resultSetAvenger.next()){
                PowerSourceDb powersourceDb = new PowerSourceDb();
                PowerSource powerSource = new PowerSource();
                powerSource = powersourceDb.getPowerSource(resultSetAvenger.getInt(4));
                avenger = new Avenger(resultSetAvenger.getInt(1), 
                    resultSetAvenger.getString(2), 
                    resultSetAvenger.getString(3), 
                    powerSource, 
                    resultSetAvenger.getString(5));
            }
        }catch(SQLException sqlex){
            throw  new SQLException(sqlex.toString());
        }
        return avenger;
    }
    
    public int updateAvenger(Avenger avenger,int avengerId) throws Exception{
    
        int result;
        
        try{
            Connection sqlconConnection = db.getConnection();
            
            String updateAvengerQuery = "Update avengers SET avengername=?,"
                    + "description=?,"
                    + "powersource=?,"
                    + "img=? where id=?";
            
            PreparedStatement statement = sqlconConnection.prepareStatement(updateAvengerQuery);
            statement.setString(1, avenger.getName());
            statement.setString(2, avenger.getDescription());
            statement.setInt(3, avenger.getPowerSource().getId());
            statement.setString(4,avenger.getImgURL());
            statement.setInt(5, avengerId);
            
            result = statement.executeUpdate();
            
        }catch(SQLException sqlex){
            throw new SQLException(sqlex.toString());
        }
        
        return result;
    }
    
}
