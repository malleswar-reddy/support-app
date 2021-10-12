package com.demo;

public class StudentMain {
    public static void main(String[] args) {
        Student student= new Student();
        student.setAddress("Turupathi");
        System.out.println(student.getAddress());

        String s1 = "Reddy";
        String s2 = new String("Reddy");
        System.out.println(s1.equals(s2));



    }
}
