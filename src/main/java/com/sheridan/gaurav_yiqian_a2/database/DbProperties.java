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
  
    //digitla ocean properties 
//    private final String driver = "org.postgresql.Driver";
//    private final String host = "db-postgresql-tor1-45287-do-user-4482482-0.db.ondigitalocean.com";
//    private final String username = "doadmin";
//    private final String password = "jbreb3biix100xq2";
//    private final String database = "defaultdb";  
    
    //local databse properties
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
       // return "jdbc:postgresql://doadmin:jbreb3biix100xq2@db-postgresql-tor1-45287-do-user-4482482-0.db.ondigitalocean.com:25060/defaultdb?sslmode=require";
        return "jdbc:postgresql://"+this.getHost()+"/"+this.getDatabase();
    }
}
