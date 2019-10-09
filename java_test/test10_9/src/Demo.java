import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Demo {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("Example");
			//Constructor cons[] = c.getConstructors(); //Ȩ��Ϊpublic�Ĺ��췽��
			Constructor cons[] = c.getDeclaredConstructors(); //�������Ȩ�޵Ĺ��췽��
			for(Constructor con: cons) {
				System.out.print(Modifier.toString(con.getModifiers()));  //���η�
				System.out.print(con.getName()+"(");  //������
				Class paras[] = con.getParameterTypes();
				for(int i=0; i<paras.length; i++) {
					System.out.print(paras[i].getName()+" args ");
					if(i<paras.length-1) {
						System.out.print(",");
					}
				}
				System.out.println("){  }");
			}
			Constructor cs1 = c.getConstructor();  //�޲������췽��
			Object obj = cs1.newInstance();
			System.out.println(obj.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
