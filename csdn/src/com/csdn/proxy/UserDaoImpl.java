package com.csdn.proxy;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("增加方法！");
    }

    @Override
    public Integer delete() {
        System.out.println("删除方法！");
        return null;
    }

    @Override
    public Boolean update() {
        System.out.println("修改方法！");
        return null;
    }

    @Override
    public List query() {
        System.out.println("查询方法！");
        return null;
    }
}
