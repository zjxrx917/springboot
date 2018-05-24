package com.csdn.designPattern;

public class ForDemo extends TempletDesign{


    @Override
    public void code() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
}
