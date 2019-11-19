 class Animal1{
    public String name;
    public Animal(String name) {
        this.name = name;
        //eat();
    }
    public void eat() {
        System.out.println(this.name+"Animal::eat");
    }
}
class Cat extends Animal1{
    public String sex;
    public Cat(String name,String sex) {
        super(name);
        this.sex = sex;
    }
    public void jump() {
        System.out.println(this.name+"jump");
    }

    @Override
    public void eat() {
        System.out.println(this.name+"Cat::eat");
    }
}

class Bird extends Animal1{
    public Bird(String name) {
        super(name);
    }

    public void fly(){
        System.out.println(this.name+"fly");
    }
}

public class TestDemo {

    public static void func() {

    }

    public static void main(String[] args) {
        Animal1 animal = new Cat("小花","man");
       /* animal.eat();
        func();*/
    }

    /*public static void main1(String[] args) {
        Animal animal = new Cat("小花","man");
        animal.eat();

        //向下转型
        Animal animal2 = new Bird("小明");
        animal2.eat();
        Bird bird = (Bird) animal2;
        bird.fly();

        Animal animal3 = new Cat("小明","man");
        if(animal3 instanceof Bird) {
            Bird bird2 = (Bird) animal3;
        }
    }*/
}

