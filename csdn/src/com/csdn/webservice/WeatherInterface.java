package com.csdn.webservice;

/**
 * 天气查询的服务接口
 */
public interface WeatherInterface {
    //通过城市名称查询天气
    String queryWeather(String cityName);
}
