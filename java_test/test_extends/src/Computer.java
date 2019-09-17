
public class Computer { //父类
	String screen = "液晶显示屏"; //成员属性
	void starUp() {  //成员方法
		System.out.println("电脑自动开机，请稍等"); 
	}
	
	void showPicture() {
		System.out.println("用鼠标点击");
	}
	
	String sayHello() {
		return "welcome";
	}
}
