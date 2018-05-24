package com.csdn.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class WeatherClient {
    public static void main(String[] args) throws Exception{
        while (true) {

            DataInputStream dataInputStream =null;
            DataOutputStream dataOutputStream =null;
            //创建socket客户端
            Socket socket =socket = new Socket("localhost", 12345);
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                //先发送数据到服务端
                dataOutputStream.writeUTF("上海");
                System.out.println("to server:" + "上海");
                //接收来自服务端的数据
                String response = dataInputStream.readUTF();
                System.out.println("收到响应：" + response);
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                //关闭流和客户端
                if (dataInputStream!=null) dataInputStream.close();
                if (dataOutputStream!=null) dataOutputStream.close();
                socket.close();
            }
        }

    }
}
