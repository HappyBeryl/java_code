
public class Seagull extends Bird{

	public Seagull(String feather) {
		super(feather);
		// TODO Auto-generated constructor stub
		System.out.println("我是一个海鸥");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("海鸥飞行");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("海鸥吃鱼");
		
	}

}
