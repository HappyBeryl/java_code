
public class Test2 {
	public static void main(String[] args) {
		DrawInterface d1 = new Qua(); //����ת��
		DrawInterface d2 = new Square();
		d1.draw();
		d2.draw();
	}

}

class Qua implements DrawInterface{

	@Override
	public void draw() {
		System.out.println("�ı�����");
	}
}

class Square implements DrawInterface{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
	
}