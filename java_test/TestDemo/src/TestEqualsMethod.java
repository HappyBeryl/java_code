import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Comparator;

public class TestEqualsMethod {
    public int rank; // 数值
    public String suit; // 花色
    public TestEqualsMethod(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof TestEqualsMethod)) {
            return false;
        }

        TestEqualsMethod card = (TestEqualsMethod)obj;
        return  rank == card.rank && suit.equals(card.suit);
    }

    public static void main1(String[] args) {
        TestEqualsMethod card1 = new TestEqualsMethod(1,"♠");
        TestEqualsMethod card2 = new TestEqualsMethod(1,"♠");
        System.out.println(card1 == card2);
        System.out.println(card1.equals(card2));
    }

    static class Person1 implements Comparable<Person1>{
        public String name;
        public int age;

        public Person1(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person1 o) {
            //return this.age - o.age;
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main2(String[] args) {
        Person1[] people = new Person1[3];
        people[0] = new Person1("wangfei",87);
        people[1] = new Person1("zhangfei",19);
        people[2] = new Person1("angbai",38);

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }

    static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class ComparatorByAge implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.age - o2.age;
        }
    }

    static class ComparatorByName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            if (o1 == o2) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.name.compareTo(o2.name);
        }
    }

    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("wangfei",87);
        people[1] = new Person("zhangfei",19);
        people[2] = new Person("angbai",38);

        //ComparatorByAge comparatorByAge = new ComparatorByAge();

       ComparatorByName comparatorByName = new ComparatorByName();

        Arrays.sort(people,comparatorByName);

        System.out.println(Arrays.toString(people));
    }




}
