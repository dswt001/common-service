package com.dake.springboot.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test002 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();

        list1.add(3);
        list2.add(2);

        list.addAll(list1);
        boolean b = list.addAll(list2);

        Map<String, Object> map;
        List<Object> list3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            map = new HashMap<>();
            map.put("a", i + 1);
//            System.out.println(list.get(i));
            list3.add(map);
        }
        System.out.println(list3);
        System.out.println(b);
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }
}
