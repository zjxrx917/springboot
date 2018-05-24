package com.csdn.designPattern;

public abstract class TempletDesign {

    public Long getTime() {
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();


        return end - start;

    }

    public abstract void code();
}
