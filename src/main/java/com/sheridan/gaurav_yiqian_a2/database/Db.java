/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author tayad
 */
public class Db {
  
    DbProperties dbProp = new DbProperties();
    private Connection con;

    public Db() {
    }
    
    public Connection getConnection(){
        
        try{
            Class.forName(dbProp.getDriver()).newInstance();
            
            con = DriverManager.getConnection(dbProp.getConnectionURL(),dbProp.getUsername(),dbProp.getPassword());
        }catch(SQLException sqlex){
            System.out.println(sqlex.toString());
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return con;
    }
    
}
