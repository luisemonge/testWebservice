/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database.dao;

import com.database.model.Login;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class LoginDAO {
    
    private Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver")
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=daitest;user=sa;password=Avianca2015!";
            //String connString="jdbc:oracle:thin:@prodHost:1521:ORCL";
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception: "+ sqlEx.toString());
            return null;
        } catch (ClassNotFoundException classEx) {
            System.out.println("Class Not Found Exception: "+ classEx.toString());
            return null;
        } catch (Exception Ex) {
            System.out.println("Exception: "+ Ex.toString());
            return null;
        }
    }
    
    public void save(Login login) throws SQLException{
        String sql = "INSERT INTO Login (idlogin, usrname, pwd) VALUES (" + login.getId() + ",'" + login.getUsername() + "','" + login.getPassword() + "')";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
    
    public List<Login> list() throws SQLException{
        String sql = "SELECT * FROM Login";
        Statement stmt = getConnection().createStatement();
        List<Login> lstLogin = new ArrayList<Login>();
        
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Login login = new Login(rs.getString("idlogin"), rs.getString("usrname"), rs.getString("pwd"));
            lstLogin.add(login);
        }
        rs.close();
        getConnection().close();
        
        return lstLogin;
    }
}
