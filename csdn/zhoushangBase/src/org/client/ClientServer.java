package org.client;

import org.tempuri.DataServiceByZS;
import org.tempuri.DataServiceByZSSoap;
import org.tempuri.ListHotelResponse;

public class ClientServer {


    public static void main(String[] args) {

        DataServiceByZS dataServiceByZS = new DataServiceByZS();

        DataServiceByZSSoap dataServiceByZSSoap = dataServiceByZS.getDataServiceByZSSoap();

        ListHotelResponse.ListHotelResult listHotelResult = dataServiceByZSSoap.listHotel("2000-01-01");

        System.out.println("from client..." + listHotelResult.getContent());
    }
}
