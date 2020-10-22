package com.dake.springboot;

import com.dake.springboot.po.Student;

public class MyComparator {

     public static int compareTo(Student o1, Student o2){
         int ageComparisonResult = o1.getAge() - o2.getAge();
         int nameComparisonResult = o1.getName().compareTo(o2.getName());
         double heightComparisonResult = o1.getHeight() - o2.getHeight();

         if (ageComparisonResult == 0){
             if (nameComparisonResult == 0){
                 if (heightComparisonResult == 0) {
                     return 0;
                 } else if (heightComparisonResult > 0){
                     return 1;
                 } else {
                     return -1;
                 }
             } else {
                 return nameComparisonResult;
             }
         } else {
             return ageComparisonResult;
         }
     }
}
