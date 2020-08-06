package review;

public class Person {
    private int age ;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    public static void main1(String[] args) {
        Person p = new Person(23, "zhang");
        System.out.println(p);
        Person p1 = (Person) p.clone();
        System.out.println(p1);
        p.setName("bai");
        System.out.println(p1.getName()); //bai
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = a;
        System.out.println(a[0]); //1
        System.out.println(b[0]); //1
        a[0] = 1000;
        System.out.println(a[0]); //1000
        System.out.println(b[0]); //1000
        System.out.println("a的引用:" +a+"b的引用:"+b); //a的引用:[I@16d3586b的引用:[I@16d3586
    }
}
