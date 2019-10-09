import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo1 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("Example1");
			Field[] fs = c.getDeclaredFields(); //������������
			for(Field f: fs) {
				System.out.print(Modifier.toString(f.getModifiers())+" "); //���η�
				System.out.print(f.getType().getSimpleName()+" ");  //��Ա��������
				System.out.print(f.getName()); //��Ա��������
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
