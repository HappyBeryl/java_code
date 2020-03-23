package com.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int option = sc.nextInt();
            Student[] student = new Student[n];
            for (int i = 0; i < n; i++) {
                student[i] = new Student(sc.next(), sc.nextInt());
            }
            if (option == 1) {
                //升序
                ComparaUp cp = new ComparaUp();
                Arrays.sort(student, cp);

            } else if (option == 0) {
                //降序
                ComparaDown cd = new ComparaDown();
                Arrays.sort(student, cd);
            }
            for (int i = 0; i < student.length; i++) {
                System.out.println(student[i]);
            }
        }
    }
}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        String ret = this.name + " " + this.score;
        return ret;
    }
}

class ComparaUp implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.score - o2.score;
    }
}

class ComparaDown implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o2.score - o1.score;
    }
}
