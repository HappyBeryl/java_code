
public class Chick extends Bird{

	public Chick(String feather) {
		super(feather);
		System.out.println("我是一只小鸡");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("小鸡跑步");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("小鸡吃米");
	}
}
