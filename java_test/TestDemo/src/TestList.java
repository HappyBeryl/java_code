import java.util.*;

class Student {
    public String name;
    public String team;
    public double grade;
    public Student(String name, String team, double grade) {
        this.name = name;
        this.team = team;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", grade=" + grade +
                '}';
    }
}

public class TestList {
    public static void main2(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("小明","1班",11.1));
        list.add(new Student("小红","2班",22.2));
        list.add(new Student("小黄","3班",33.3));
        System.out.println(list);
        System.out.println("===============");
        for(Student student: list) {
            System.out.println(student);
        }

    }

    //welcome to xian    come ==> wl t xian
    public static List<Character> func (String str1, String str2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!(str2.contains(str1.charAt(i) + ""))) {
                ret.add(str1.charAt(i));
            }
        }
        return ret;
    }

    public static void main3(String[] args) {
        String str1 = "welcome to xian";
        String str2 = "come";
        List<Character> list = func(str1, str2);
        System.out.println(list);
    }

    //杨辉三角
    //进来1 -》 中间 -》最后1
//    public static List<List<Integer>> generator(int numRows) {
//        List<List<Integer>> tringle = new ArrayList<>();
//        if (numRows == 0) {
//            return tringle;
//        }
//        tringle.add()
//    }

    public static void main(String[] args) {

    }

}
