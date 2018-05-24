package com.csdn.java8;
@FunctionalInterface
public interface MyFunction<T> {
    Integer getOperate(T t);
}
