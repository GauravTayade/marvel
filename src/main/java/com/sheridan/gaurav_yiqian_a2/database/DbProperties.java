/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
@author Gaurav Tayade
*/
package com.sheridan.gaurav_yiqian_a2.database;

/**
 *
 * @author tayad
 */
public class DbProperties {
  
    private final String driver = "org.postgresql.Driver";
    private final String host = "localhost";
    private final String username = "postgres";
    private final String password = "root";
    private final String database = "MyDb";  
    private String connectionURL;

    public String getDriver() {
        return driver;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }            
    
    public String getConnectionURL(){
        return "jdbc:postgresql://"+this.getHost()+"/"+this.getDatabase();
    }
}
