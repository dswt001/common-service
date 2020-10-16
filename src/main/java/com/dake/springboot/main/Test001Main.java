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
        System.out.println(judgeOddOrEvenNum(-10));
    }

    /**
     * judge a number is odd or even number.
     * if returns 1, this number is odd;
     * if returns 0, this number is even number.
     *
     * References The <code>jdk.internal.misc.Unsafe#getLongUnaligned</code> and it's following methods.
     *
     * @param number
     * @return
     */
    public static int judgeOddOrEvenNum(int number){
        if ((number & 1) == 1){
            return 1;
        }else {
            return 0;
        }
    }
}
