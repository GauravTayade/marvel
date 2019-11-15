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
/**
 *
 * @author tayad
 */
public class UserDb {
    
    Db db = new Db();
    boolean isUser = false;
    User user=null;
    
    public boolean loginCheck(String username, String password)throws Exception{
    
        String sqlUserSelect;
        try{
            Connection sqlConnection = db.getConnection();
            sqlUserSelect = "select * from users where username=?";
            PreparedStatement statement = sqlConnection.prepareStatement(sqlUserSelect);
            statement.setString(1, username);
            
            ResultSet resultUsers = statement.executeQuery();
            
            
            if(resultUsers.next()){
                if(resultUsers.getString(5).equals(password)){
                    isUser=true;
                    user = new User(resultUsers.getString(2),
                            resultUsers.getString(3), resultUsers.getString(4),
                            resultUsers.getString(5));
                }
            }
            
        }catch(SQLException sqlex){
            throw new SQLException(sqlex.toString());
        }
        
        return isUser;
    }
    
    public User getUser(){
        return this.user;    
    }
    
}
