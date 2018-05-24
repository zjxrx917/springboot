package com.csdn.proxy;

import java.util.List;

public interface UserDao {
    void add();

    Integer delete();

    Boolean update();

    List query();
}
