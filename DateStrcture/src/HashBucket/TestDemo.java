package HashBucket;


public class TestDemo {

    public static void main(String[] args) {
        Person person = new Person("gaobo",18);
        Person person2 = new Person("gaobo", 18);
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
    }
    public static void main1(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(1, 34);
        hashBucket.put(1, 24);
        hashBucket.put(3, 9);
        hashBucket.put(7, 56);
        hashBucket.put(4 ,44);
        System.out.println("999");
        System.out.println(hashBucket.getValue(3));
    }
}
