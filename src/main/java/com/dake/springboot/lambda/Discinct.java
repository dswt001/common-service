package com.dake.springboot.lambda;

import com.dake.springboot.po.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Discinct {
    public static void main(String[] args) {
        discinct();
    }

    private static void discinct(){
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("zhangsan", 18, 175.00);
        Student s2 = new Student("zhangsan", 18, 176.00);
        Student s3 = new Student("zhangsan", 19, 177.00);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.forEach(student -> {
            System.out.println( "姓名：" + student.getName() + "年龄" + student.getAge() + "身高" + student.getHeight());
        });

        System.out.println("---------------------------");

        List<Student> list1 = list.stream().sorted((Comparator.comparing(Student::getHeight).reversed())).collect(Collectors.toList());
        list1.forEach(student -> {
            System.out.println( "姓名：" + student.getName() + "年龄" + student.getAge() + "身高" + student.getHeight());
        });

        System.out.println("---------------------------");

        ArrayList<Student> collect = list1.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(
                        student -> student.getName() + "#" + student.getAge()
                ))), ArrayList::new));

        collect.forEach(student -> {
            System.out.println( "姓名：" + student.getName() + "年龄" + student.getAge() + "身高" + student.getHeight());
        });


    }
}
