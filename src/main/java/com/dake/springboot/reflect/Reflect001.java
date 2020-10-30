package com.dake.springboot.reflect;

public class Reflect001 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> name = Class.forName("com.dake.springboot.po.Student");
//        name.newInstance();

        Class<? extends Class> aClass = name.getClass();


//        String name1 = name.getClassLoader().getName();


        System.out.println(name);
//        System.out.println(name1);
    }
}
