package uesFile.com;

import java.io.*;

public class SerializeDemo {
    // 声明实现 Serializable 接口
    // 声明之后，就拥有了可以序列号和反序列化的功能了
    static class Person implements Serializable {
        String name;
        int age;
    }

    //读
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (InputStream is = new FileInputStream("名单.binary")) {
            try (ObjectInputStream ois = new ObjectInputStream(is)) {
                Person p = (Person) ois.readObject();
                System.out.println(p.name);
                System.out.println(p.age);
                Person q = (Person) ois.readObject();
                System.out.println(q.name);
                System.out.println(q.age);
            }
        }
    }

    /*
    //写
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.name = "人员1"; p.age = 34;
        Person q = new Person();
        q.name = "人员2"; q.age = 18;

        try (OutputStream os = new FileOutputStream("名单.binary")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(p);
                oos.writeObject(q);

                oos.flush();
            }
        }
    }
    */
}
