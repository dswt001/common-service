package com.dake.springboot.main;

import com.dake.springboot.MyComparator;
import com.dake.springboot.po.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JDK8 {

    public static void main(String[] args) {
        compareList();
    }

    public static void compareList() {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");
        System.out.println(list);
        System.out.println("-----------------------------");
//        list.sort(Comparator.comparing(String::strip).reversed());
//        System.out.println(list);
        System.out.println("-----------------------------");
//        List<String> list1 = list.stream().sorted(Comparator.comparing(String::strip).reversed()).collect(Collectors.toList());
//        System.out.println(list1);
        Collections.sort(list);
        System.out.println(list);

        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student("zhangsan", 30, 175.5);
        Student s2 = new Student("lisi", 18, 180);
        Student s3 = new Student("wangwu", 18, 169);
        Student s4 = new Student("maliu", 26, 177.3);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        // 降序
//        studentList.sort(Comparator.comparing(Student::getAge).reversed());
        // 先按照age排序，如果age相同的按照height排序
//        studentList.sort(Comparator.comparing(Student::getAge).thenComparing(Student::getHeight));
        // 自然顺序排序
//        studentList.sort(Comparator.naturalOrder());
        // 自然顺序降序
        studentList.sort(Comparator.reverseOrder());
//        List<Student> studentList1 = studentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());

        studentList.forEach(student -> {
            System.out.println(student.getName() + ":" + student.getAge() + ":" + student.getHeight());
        });

//        System.out.println(studentList);

        Collections.sort(studentList);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Collections.sort(studentList, (o1, o2) -> {
            return o1.getAge() -o2.getAge();
        });

        Collections.sort(studentList, (o1, o2) -> MyComparator.compareTo(o1, o2));
    }
}
