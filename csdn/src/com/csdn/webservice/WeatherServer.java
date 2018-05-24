package com.csdn.webservice;

import javax.xml.ws.Endpoint;

public class WeatherServer {
    public static void main(String[] args) {
        //通过jaxws发布服务
        Endpoint publish = Endpoint.publish("http://localhost:12345/weather", new WeatherInterfaceImpl());


    }
}
