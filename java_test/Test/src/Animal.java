//public class Animal {
//    protected  String name;
//
//    public Animal(String name) {
//        this.name = name;
//    }
//
//    public void eat() {
//        System.out.println("吃饭饭");
//    }
//}
//
//class Cat extends Animal {
//    public Cat(String name) {
//        //使用super调用父类的构造方法
//        super(name);
//    }
//}
//
//class Bird extends Animal {
//    public Bird(String name) {
//        super(name);
//    }
//
//    public void fly() {
//        System.out.println("飞飞飞");
//    }
//    Animal animal1 = new Bird("二哈"); //向上转型
//    Bird bird = (Bird)animal1;  //强制类型转换（向下转型）
//    //bird.x; //x可以是Bird当中的方法
//    Animal animal = new Cat("咪咪");
//    Bird bird1 = (Bird)animal;
//    //bird.x; //x为Bird当中的方法
//}
//
//class Test1 {
//    public static void main(String[] args) {
//        Bird bird = new Bird("二哈");
//        feed(bird);
//    }
//
//    public static void feed(Animal animal) { //向上转型
//        animal.eat();
//    }
//}
//
// class Test {
//    public static void main(String[] args) {
//        //向上转型
//        Animal animal = findMyAnimal();
//    }
//
//    public static Animal findMyAnimal() {
//        Bird bird = new Bird("二哈");
//        return bird;
//    }
//
//     Animal animal = new Cat("咪咪");
////    if(animal instanceof Bird) {
////         Bird bird = (Bird)animal;
////         bird.x; //x为Bird当中的方法
////     }
//
//
//}
//
//
