package com.dake.springboot.main;

import com.dake.springboot.po.Student;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test003 {
    // 合规解决方案的随机数
        SecureRandom instanceStrong;

    {
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void doSomeThingCommon(){
        int nextInt = this.instanceStrong.nextInt();
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
//        Student s1;
        Student s1 = new Student();
        for (int i = 0; i < 5; i++) {

            list.add(s1);
        }
        System.out.println(list);

        // 不合规的解决方案-随机数
        Random random = new Random();
        int i = random.nextInt(10);

        list.contains("a");

        System.out.println("-----------------1111111--------------");
//        String a = "%0" + 5 + "d";
//        StringBuilder d = new StringBuilder("%0").append(5).append("d");
//        System.out.println(String.format(d.toString(), "aa"));

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sb.append("0");
        }

        System.out.println(sb);

        DecimalFormat decimalFormat = new DecimalFormat(sb.toString());
        String format = decimalFormat.format(67);
        System.out.println("-------"+format);

        System.out.println("-----------------------22222222222-----------");
        String sub = "AB1111AB222";
        String ab = sub.replaceFirst("AB", "");
        String ab1 = sub.replace("AB", "");

        sub.substring(1);
        System.out.println(ab);
        System.out.println(ab1);
    }


}
