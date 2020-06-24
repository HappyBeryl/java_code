package com.test;

public class ReflectClassDemo {
    public static void main(String[] args) {

        Class<?> c1 = Student.class;
        try {
            Student student = (Student) c1.newInstance();
            System.out.println(student);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
