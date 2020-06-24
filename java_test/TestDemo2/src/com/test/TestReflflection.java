package com.test;

class Student{
    private String name;
    public int age;
    public Student() {

    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eating");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestReflflection {

    public static void main(String[] args) {
        System.out.println(Student.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
    public static void main1(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.test.Student");

            Class<?> c2 = Student.class;

            Class<?> c3 = new Student().getClass();

            System.out.println(c1.equals(c2));
            System.out.println(c1.equals(c3));
            System.out.println(c2.equals(c3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
