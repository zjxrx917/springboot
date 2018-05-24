package com.csdn.webservice;

import javax.jws.WebService;

/**
 * 天气接口查询服务的实现
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    /**
     * 方法被调用了，表示客户端请求webservice服务
     * @param cityName
     * @return
     */
    @Override
    public String queryWeather(String cityName) {
        System.out.println("from client..." + cityName);
        //处理返回结果
        String result = "晴转多云";
        System.out.println("to client..." + result);
        return result;
    }
}
