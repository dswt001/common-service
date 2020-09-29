package com.dake.springboot.main;

import java.util.Arrays;
import java.util.List;

public class Test001Main {

    public static void main(String[] args) {
        String a = "abc";
        a = "1";
        System.out.println(a);

        List<String> list = Arrays.asList("d", "b", "c", "a");
        list.forEach(str -> {
                    if (!str.equals("a")) {
                        System.out.println("匹配不正确：" + str);
                    }
                }

        );
    }
}
