/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.database.dao.LoginDAO;
import com.database.model.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author HP
 */
@WebService(serviceName = "DatabaseWS")
@Stateless()
public class DatabaseWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "save")
    public String save(@WebParam(name = "id") String id, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        LoginDAO lDao = new LoginDAO();
        Login login = new Login(id, username, password);
        try {
            lDao.save(login);
            return "Guardado";
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWS.class.getName()).log(Level.SEVERE, null, ex);
            return "Fallido";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "list")
    public List<Login> list() {
        LoginDAO lDao = new LoginDAO();
        try {
            return lDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWS.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Login>();
        }
    }
}
