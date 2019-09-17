
public class Pad extends Computer{ //子类
	String battery = "50000毫安";
	
	public Pad() {
		super();
		this.screen = super.screen;
	}
	
	void open5g() {
		System.out.println("打开5g网络");
	}
	
	void showPicture() { //子类可重写方法,覆盖原来的方法
		System.out.println("用手指点击");
	}
	
	String sayHello() {
	//	return "welcome" + "ipad";
		return super.sayHello() + "ipad"; //super的用法，调用父类成员方法  类似this
	}
}
