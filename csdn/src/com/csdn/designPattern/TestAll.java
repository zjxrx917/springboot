package com.csdn.designPattern;

import org.junit.Test;

public class TestAll {
    //模板设计模式测试
    @Test
    public void test1() {
        TempletDesign templetDesign = new ForDemo();

        System.out.println("消耗：" + templetDesign.getTime() + "毫秒");
    }
}
