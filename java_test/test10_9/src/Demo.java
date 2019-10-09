import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Demo {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("Example");
			//Constructor cons[] = c.getConstructors(); //权限为public的构造方法
			Constructor cons[] = c.getDeclaredConstructors(); //获得所有权限的构造方法
			for(Constructor con: cons) {
				System.out.print(Modifier.toString(con.getModifiers()));  //修饰符
				System.out.print(con.getName()+"(");  //方法名
				Class paras[] = con.getParameterTypes();
				for(int i=0; i<paras.length; i++) {
					System.out.print(paras[i].getName()+" args ");
					if(i<paras.length-1) {
						System.out.print(",");
					}
				}
				System.out.println("){  }");
			}
			Constructor cs1 = c.getConstructor();  //无参数构造方法
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
