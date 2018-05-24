package com.csdn.thread;

public class SellTicket implements Runnable{
    //定义100张票
    private int tickets = 10;
    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                    //模拟真实延迟100毫秒
                    try {
                        Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
            }
        }
    }
}
