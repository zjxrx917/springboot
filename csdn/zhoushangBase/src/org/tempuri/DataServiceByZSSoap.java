
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DataServiceByZSSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DataServiceByZSSoap {


    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListScenicResponse.ListScenicResult
     */
    @WebMethod(action = "http://tempuri.org/listScenic")
    @WebResult(name = "listScenicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listScenic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListScenic")
    @ResponseWrapper(localName = "listScenicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListScenicResponse")
    public org.tempuri.ListScenicResponse.ListScenicResult listScenic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ScenicPicResponse.ScenicPicResult
     */
    @WebMethod(operationName = "ScenicPic", action = "http://tempuri.org/ScenicPic")
    @WebResult(name = "ScenicPicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ScenicPic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ScenicPic")
    @ResponseWrapper(localName = "ScenicPicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ScenicPicResponse")
    public org.tempuri.ScenicPicResponse.ScenicPicResult scenicPic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListHotelResponse.ListHotelResult
     */
    @WebMethod(action = "http://tempuri.org/listHotel")
    @WebResult(name = "listHotelResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listHotel", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListHotel")
    @ResponseWrapper(localName = "listHotelResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListHotelResponse")
    public org.tempuri.ListHotelResponse.ListHotelResult listHotel(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.HotelPicResponse.HotelPicResult
     */
    @WebMethod(operationName = "HotelPic", action = "http://tempuri.org/HotelPic")
    @WebResult(name = "HotelPicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "HotelPic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HotelPic")
    @ResponseWrapper(localName = "HotelPicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HotelPicResponse")
    public org.tempuri.HotelPicResponse.HotelPicResult hotelPic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListFormHouseResponse.ListFormHouseResult
     */
    @WebMethod(action = "http://tempuri.org/listFormHouse")
    @WebResult(name = "listFormHouseResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listFormHouse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListFormHouse")
    @ResponseWrapper(localName = "listFormHouseResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListFormHouseResponse")
    public org.tempuri.ListFormHouseResponse.ListFormHouseResult listFormHouse(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.FormHousePicResponse.FormHousePicResult
     */
    @WebMethod(operationName = "FormHousePic", action = "http://tempuri.org/FormHousePic")
    @WebResult(name = "FormHousePicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "FormHousePic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.FormHousePic")
    @ResponseWrapper(localName = "FormHousePicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.FormHousePicResponse")
    public org.tempuri.FormHousePicResponse.FormHousePicResult formHousePic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListTravelResponse.ListTravelResult
     */
    @WebMethod(action = "http://tempuri.org/listTravel")
    @WebResult(name = "listTravelResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listTravel", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListTravel")
    @ResponseWrapper(localName = "listTravelResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListTravelResponse")
    public org.tempuri.ListTravelResponse.ListTravelResult listTravel(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListrestaurantResponse.ListrestaurantResult
     */
    @WebMethod(action = "http://tempuri.org/listrestaurant")
    @WebResult(name = "listrestaurantResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listrestaurant", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Listrestaurant")
    @ResponseWrapper(localName = "listrestaurantResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListrestaurantResponse")
    public org.tempuri.ListrestaurantResponse.ListrestaurantResult listrestaurant(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListentertainmentResponse.ListentertainmentResult
     */
    @WebMethod(action = "http://tempuri.org/listentertainment")
    @WebResult(name = "listentertainmentResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listentertainment", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Listentertainment")
    @ResponseWrapper(localName = "listentertainmentResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListentertainmentResponse")
    public org.tempuri.ListentertainmentResponse.ListentertainmentResult listentertainment(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListshoppingResponse.ListshoppingResult
     */
    @WebMethod(action = "http://tempuri.org/listshopping")
    @WebResult(name = "listshoppingResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listshopping", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Listshopping")
    @ResponseWrapper(localName = "listshoppingResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListshoppingResponse")
    public org.tempuri.ListshoppingResponse.ListshoppingResult listshopping(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ListpublicserveResponse.ListpublicserveResult
     */
    @WebMethod(action = "http://tempuri.org/listpublicserve")
    @WebResult(name = "listpublicserveResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "listpublicserve", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Listpublicserve")
    @ResponseWrapper(localName = "listpublicserveResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ListpublicserveResponse")
    public org.tempuri.ListpublicserveResponse.ListpublicserveResult listpublicserve(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.RestaurantPicResponse.RestaurantPicResult
     */
    @WebMethod(operationName = "RestaurantPic", action = "http://tempuri.org/RestaurantPic")
    @WebResult(name = "RestaurantPicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "RestaurantPic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RestaurantPic")
    @ResponseWrapper(localName = "RestaurantPicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RestaurantPicResponse")
    public org.tempuri.RestaurantPicResponse.RestaurantPicResult restaurantPic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.EntertainmentPicResponse.EntertainmentPicResult
     */
    @WebMethod(operationName = "EntertainmentPic", action = "http://tempuri.org/EntertainmentPic")
    @WebResult(name = "EntertainmentPicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "EntertainmentPic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EntertainmentPic")
    @ResponseWrapper(localName = "EntertainmentPicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EntertainmentPicResponse")
    public org.tempuri.EntertainmentPicResponse.EntertainmentPicResult entertainmentPic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.ShoppingPicResponse.ShoppingPicResult
     */
    @WebMethod(operationName = "ShoppingPic", action = "http://tempuri.org/ShoppingPic")
    @WebResult(name = "ShoppingPicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ShoppingPic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ShoppingPic")
    @ResponseWrapper(localName = "ShoppingPicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ShoppingPicResponse")
    public org.tempuri.ShoppingPicResponse.ShoppingPicResult shoppingPic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

    /**
     * 
     * @param updatetime
     * @return
     *     returns org.tempuri.PublicservePicResponse.PublicservePicResult
     */
    @WebMethod(operationName = "PublicservePic", action = "http://tempuri.org/PublicservePic")
    @WebResult(name = "PublicservePicResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "PublicservePic", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PublicservePic")
    @ResponseWrapper(localName = "PublicservePicResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PublicservePicResponse")
    public org.tempuri.PublicservePicResponse.PublicservePicResult publicservePic(
        @WebParam(name = "updatetime", targetNamespace = "http://tempuri.org/")
        String updatetime);

}
