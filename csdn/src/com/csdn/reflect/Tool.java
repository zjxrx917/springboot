package com.csdn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Tool {
    public static void setProperty(Object obj, String property, Object value) throws Exception {

        Class<?> aClass = obj.getClass();

//        Constructor<?> con = aClass.getDeclaredConstructor();
//        con.setAccessible(true);
//        Object o = con.newInstance();

        Field field = aClass.getDeclaredField(property);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
