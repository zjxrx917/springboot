package com.csdn.thread;

import org.junit.Test;

public class SellTicketDemo {

    @Test
    public void test01() {
        SellTicket st = new SellTicket();

        Thread th = new Thread(st, "窗口1");
        Thread th2 = new Thread(st, "窗口2");
        Thread th3 = new Thread(st, "窗口3");

        th.start();
        th2.start();
        th3.start();

    }
}
