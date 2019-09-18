//
//public class Demo {
//	public static void main(String[] args) {
////		Person person = new Student("tom");
////		Student person_1 = (Student)person;
//		Animal jack = new Fish();
//		jack.move();
//		jack = new mac();
//		jack.move();
//		
//	}
//}
//
//class Fish extends Animal{
//	void move() {
//		System.out.println("游泳");
//	}
//}
//
//class mac extends Animal{
//	void move() {
//		System.out.println("飞行");
//	}
//}
//
//class Animal{
//	void move(){
//		
//	}
//}
public class Demo{
	public static void main(String[] args) {
		Teacher lee = new EnglishTeacher();
		Teacher wu = new MathTeacher();
		lee.teaching();
		wu.teaching();
	}
}

abstract class Teacher{
	public abstract void teaching();
}

class MathTeacher extends Teacher{
	public void teaching() {
		System.out.println("数学");
	}
}

class EnglishTeacher extends Teacher{
	@Override
	public void teaching() {
		System.out.println("yingyu");
	}
}