
public class Test2 {
	public static void main(String[] args) {
		DrawInterface d1 = new Qua(); //向下转换
		DrawInterface d2 = new Square();
		d1.draw();
		d2.draw();
	}

}

class Qua implements DrawInterface{

	@Override
	public void draw() {
		System.out.println("四边形类");
	}
}

class Square implements DrawInterface{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("正方形类");
	}
	
}