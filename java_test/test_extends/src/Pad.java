
public class Pad extends Computer{ //����
	String battery = "50000����";
	
	public Pad() {
		super();
		this.screen = super.screen;
	}
	
	void open5g() {
		System.out.println("��5g����");
	}
	
	void showPicture() { //�������д����,����ԭ���ķ���
		System.out.println("����ָ���");
	}
	
	String sayHello() {
	//	return "welcome" + "ipad";
		return super.sayHello() + "ipad"; //super���÷������ø����Ա����  ����this
	}
}
