
package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DataServiceByZS", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://i.tourzj.com/InternalInterface/DataServiceByZS.asmx?wsdl")
public class DataServiceByZS
    extends Service
{

    private final static URL DATASERVICEBYZS_WSDL_LOCATION;
    private final static WebServiceException DATASERVICEBYZS_EXCEPTION;
    private final static QName DATASERVICEBYZS_QNAME = new QName("http://tempuri.org/", "DataServiceByZS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://i.tourzj.com/InternalInterface/DataServiceByZS.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DATASERVICEBYZS_WSDL_LOCATION = url;
        DATASERVICEBYZS_EXCEPTION = e;
    }

    public DataServiceByZS() {
        super(__getWsdlLocation(), DATASERVICEBYZS_QNAME);
    }

    public DataServiceByZS(WebServiceFeature... features) {
        super(__getWsdlLocation(), DATASERVICEBYZS_QNAME, features);
    }

    public DataServiceByZS(URL wsdlLocation) {
        super(wsdlLocation, DATASERVICEBYZS_QNAME);
    }

    public DataServiceByZS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DATASERVICEBYZS_QNAME, features);
    }

    public DataServiceByZS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DataServiceByZS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DataServiceByZSSoap
     */
    @WebEndpoint(name = "DataServiceByZSSoap")
    public DataServiceByZSSoap getDataServiceByZSSoap() {
        return super.getPort(new QName("http://tempuri.org/", "DataServiceByZSSoap"), DataServiceByZSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DataServiceByZSSoap
     */
    @WebEndpoint(name = "DataServiceByZSSoap")
    public DataServiceByZSSoap getDataServiceByZSSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "DataServiceByZSSoap"), DataServiceByZSSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DATASERVICEBYZS_EXCEPTION!= null) {
            throw DATASERVICEBYZS_EXCEPTION;
        }
        return DATASERVICEBYZS_WSDL_LOCATION;
    }

}
