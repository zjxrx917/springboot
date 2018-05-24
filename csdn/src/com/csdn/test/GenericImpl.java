package com.csdn.test;

public  class GenericImpl<T> implements Generic<T> {

    @Override
    public <T> T show(T t) {
        return null;
    }

    public static void testMultiParam(String... params){
        System.out.println(params.length);
    }
}
