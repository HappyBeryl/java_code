
public class Chick extends Bird{

	public Chick(String feather) {
		super(feather);
		System.out.println("����һֻС��");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("С���ܲ�");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("С������");
	}
}
