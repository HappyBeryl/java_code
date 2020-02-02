import java.lang.reflect.Array;
import java.util.*;
class Apple{
    public String color;
    public int count;
    public int id = count++;
    public long id(){
        return id;
    }
}

class Orange {}

class People implements Comparable<People>{
    String name;
    int age;

    @Override
    public int compareTo(People o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AppleAndOrangeWitnoutGenerics {
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        System.out.println(list);
        Map<String,String> map = new HashMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(Arrays.asList());
    }

    public static void main2(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size() ; i++) {
           // apples.get(i).id; //会出现语法错误
            ((Apple)apples.get(i)).id();
        }
    }

    public static void test(List<String> list) {

    }

    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        Collections.sort(people);
        System.out.println(people);
        List<String> list = new ArrayList<>();
        test(list);
    }

}
