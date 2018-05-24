package com.csdn.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {

    @Test
    public void test01() {
        UserDao ud = new UserDaoImpl();

        InvocationHandler handler = new MyInvocationHandler(ud);
        //获取代理对象
        Object proxyInstance = Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), handler);

        UserDao proxy = (UserDao) proxyInstance;
        proxy.add();
        proxy.delete();
        proxy.query();
        proxy.update();
    }

    @Test
    public void test2() {
        UserDao userDao = new UserDaoImpl();
        InvocationHandler in = new MyInvocationHandler(userDao);
        //获取代理对象
        Object proxyInstance = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), in);
        //调用方法
        UserDao user = (UserDao)proxyInstance;
        user.update();
        user.query();
        user.delete();
        user.add();

    }
}
