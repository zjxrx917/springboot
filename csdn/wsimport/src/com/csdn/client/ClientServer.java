package com.csdn.client;


import com.csdn.webservice.WeatherInterfaceImpl;
import com.csdn.webservice.WeatherInterfaceImplService;

public class ClientServer {
    public static void main(String[] args) {
        //第一步：创建一个服务视图的对象
        WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
        //第二步：通过服务视图对象创建portType
        WeatherInterfaceImpl weatherInterfaceImplPort = weatherInterfaceImplService.getWeatherInterfaceImplPort();
        //通过portType调用服务方法
        String cityName = "上海";
        String result = weatherInterfaceImplPort.queryWeather(cityName);
        System.out.println("from server..." + result);
    }
}
