package com.csdn.map;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class MapTest {

    //遍历map推荐方式
    @Test
    public void test1() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("zhangsan", 18);
        map.put("lisi", 15);
        map.put("wangwu", 38);
        map.put("zhaoliu", 28);

        for (Map.Entry<String, Integer> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey());
        }

    }

    @Test
    public void test2() {
        SimpleDateFormat sfd = new SimpleDateFormat("HH:mm:ss");
        String date = sfd.format(new Date());
        String format = sfd.format(new Date().getTime());
        System.out.println(format);
    }

}
