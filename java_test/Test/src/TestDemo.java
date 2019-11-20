class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name + "animal eat");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.name + "cat eat");
    }
}

public class  TestDemo {
    public static void main(String[] args) {
        Animal animal = new Cat("花花"); //向上转型
        animal.eat();
    }
}