package com.dake.springboot.main;

import com.dake.springboot.MyComparator;
import com.dake.springboot.po.Student;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
            return o1.getAge() - o2.getAge();
        });

        Collections.sort(studentList, (o1, o2) -> MyComparator.compareTo(o1, o2));

        List<String> list1 = Arrays.asList("a", "d", "c");
        list1.forEach(str -> {
            boolean contains = list1.contains("a");
        });

        String[] strings = list1.toArray(new String[list1.size()]);


        System.out.println("------------------------");
        Student student = new Student();
        student.setAge(18);
        for (String str : strings) {
//            System.out.println(str);
            if (str.equals("c")) {
                student.setAge(15);
            } else {
                student.setAge(20);
            }
            System.out.println(student.getAge());
        }

        System.out.println("-------------AAA-----------");
        List<Object> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<String> list3 = Arrays.asList("a", "d", "c");
            list3.forEach(str -> {
                list2.add(str);
            });
        }
        System.out.println(list2);

        System.out.println("------------date-----------");
        LocalDate now = LocalDate.now();
        int len =  now.lengthOfYear();
        LocalDate localDate = now.plusYears(17L);
        String yy = now.format(DateTimeFormatter.ofPattern("yy"));
        String yy1 = localDate.format(DateTimeFormatter.ofPattern("YY"));
        System.out.println(len);
        System.out.println(yy);
        System.out.println(yy1);

        System.out.println("----------atomic------------");

        AtomicInteger atomicInteger = new AtomicInteger(000);
        int i = atomicInteger.getAndAdd(1);
        System.out.println(i);
        System.out.println(atomicInteger);
//        if (String.valueOf(i).contains("4")){}

        AtomicReference<Object> ar = new AtomicReference<>();

//        Integer a = 00001;
        BigDecimal bigDecimal = new BigDecimal(00001);
        BigDecimal plus = bigDecimal.plus();
        System.out.println(plus);

        System.out.println("--------------number-----------");
        String format = String.format("%03d", 100);
        System.out.println(format);
        System.out.println("------charat");

        String a = "abcdaa";
//        char c = a.charAt(1);
//        System.out.println(c);
//        System.out.println(a.indexOf("b"));
        System.out.println(a.indexOf("c", 1));
        String a1 = a.replace("a", "0");
        System.out.println(a1);
        System.out.println(a);

    }

}
