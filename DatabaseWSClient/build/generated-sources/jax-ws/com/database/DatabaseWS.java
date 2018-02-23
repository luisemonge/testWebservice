
package com.database;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DatabaseWS", targetNamespace = "http://database.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DatabaseWS {


    /**
     * 
     * @return
     *     returns java.util.List<com.database.Login>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "list", targetNamespace = "http://database.com/", className = "com.database.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://database.com/", className = "com.database.ListResponse")
    @Action(input = "http://database.com/DatabaseWS/listRequest", output = "http://database.com/DatabaseWS/listResponse")
    public List<Login> list();

    /**
     * 
     * @param password
     * @param id
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "save", targetNamespace = "http://database.com/", className = "com.database.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "http://database.com/", className = "com.database.SaveResponse")
    @Action(input = "http://database.com/DatabaseWS/saveRequest", output = "http://database.com/DatabaseWS/saveResponse")
    public String save(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://database.com/", className = "com.database.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://database.com/", className = "com.database.HelloResponse")
    @Action(input = "http://database.com/DatabaseWS/helloRequest", output = "http://database.com/DatabaseWS/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}