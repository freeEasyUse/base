
package org.base.webservice.client;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceServer", targetNamespace = "http://server.webservice.base.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceServer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://server.webservice.base.org/", className = "org.base.webservice.client.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://server.webservice.base.org/", className = "org.base.webservice.client.SayHelloResponse")
    @Action(input = "http://server.webservice.base.org/WebServiceServer/sayHelloRequest", output = "http://server.webservice.base.org/WebServiceServer/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
