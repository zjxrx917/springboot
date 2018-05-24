package com.csdn.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherServerRunnable implements Runnable {
    private Socket accept;
    public WeatherServerRunnable(Socket socket) {
        this.accept = socket;
    }
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
    @Override
    public void run() {

        try {
            //创建服务端socket，端口号最好大于10000
            System.out.println("服务端启动...");
            //监听客户端连接
            //Socket accept = serverSocket.accept();
            //准备接收数据的流
            dataInputStream = new DataInputStream(accept.getInputStream());

            //准备发送数据的流
            dataOutputStream = new DataOutputStream(accept.getOutputStream());

            //获取接收的数据
            String city = dataInputStream.readUTF();
            System.out.println("from client:" + city);
            //处理数据(休眠一秒模拟处理数据的时间)
            Thread.sleep(1000L);
            String result = "多云";//简单返回一个结果

            dataOutputStream.writeUTF(result);
            System.out.println("to client:" + result + "Thread:" + Thread.currentThread().getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //释放io资源
            if (dataInputStream!=null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dataOutputStream!=null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //socket服务端一般不用关闭
        }
    }
}
