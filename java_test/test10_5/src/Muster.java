import java.util.*;

public class Muster {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		System.out.println("�����ǿյ���"+c.isEmpty()+"���ϵĳ���"+c.size());
		c.add("���");
		c.add(3.14);
		c.add(new Object());
		System.out.println("�����ǿյ���"+c.isEmpty()+"���ϵĳ���"+c.size());
		
		c.remove(3.14);
		
		Iterator it = c.iterator(); //���� ���������е�Ԫ�� һһ���
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
}
