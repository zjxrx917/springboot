package org.client;


import org.tempuri.DataServiceByZSSoap;
import org.tempuri.EntertainmentPicResponse;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientServer2 {
    public static void main(String[] args) {
        //第二种客户端编写方式（使用Service类来完成, 推荐使用这种）

        //创建webservice的RUL，可以指定说明书的地址，或者webservice的地址
        URL url = null;
        try {
            url = new URL("http://i.tourzj.com/InternalInterface/DataServiceByZS.asmx?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //第一个参数是：命名空间，第二个参是：命名空间的服务视图
        QName qName = new QName("http://tempuri.org/", "DataServiceByZS");
        //第一步：创建一个服务视图的对象
        Service service = Service.create(url, qName);

        //第二步：通过服务视图对象创建portType
        //WeatherInterfaceImpl weatherInterfaceImplPort = weatherInterfaceImplService.getWeatherInterfaceImplPort();
        DataServiceByZSSoap port = service.getPort(DataServiceByZSSoap.class);

        //通过portType调用服务方法
        //String cityName = "上海";
        //String result = weatherInterfaceImplPort.queryWeather(cityName);
        EntertainmentPicResponse.EntertainmentPicResult entertainmentPicResult = port.entertainmentPic("2000-01-01");
        System.out.println("from server..." + entertainmentPicResult.getContent());
    }
}
