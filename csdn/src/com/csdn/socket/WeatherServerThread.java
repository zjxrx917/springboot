package com.csdn.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class WeatherServerThread {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket accept = serverSocket.accept();
//            Thread thread = new Thread(new WeatherServerRunnable(accept));
//            thread.start();
            new Thread(new WeatherServerRunnable(accept)).start();
            //正式的开发，要使用线程池:ThreadPoolExecutor

        }
    }
}
