//
//public class Test {
//	public static void main(String[] args) {
//		Computer com = new Computer();
//		Pad ipad  = new Pad();
////		System.out.println(com.screen);
////		com.starUp();
////		System.out.println(ipad.screen);
////		ipad.starUp();
////		ipad.open5g();
////		System.out.println(ipad.battery);
////		com.showPicture();
////		ipad.showPicture();
//		
//	}
//
//}


public class Test {
	public static void main(String[] args) {
		Child child = new Child("tom");
		System.out.println(child.name);
	}
}

class Parent{
	String name;
	public Parent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
}

class Child extends Parent{
	String name = "jack";
	public Child(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
}