import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo2 {
	public static void main(String[] args) {
		Class c;
		try {
			c = Class.forName("java.lang.String");
			Method ms[] = c.getDeclaredMethods();
			for(Method m:ms) {
				System.out.print(Modifier.toString(m.getModifiers())+" "); //修饰符
				System.out.print(m.getReturnType().getSimpleName()+" ");  //返回类型
				System.out.print(m.getName()+"("); //方法名
				Class paras[] = m.getParameterTypes();
				for(int i = 0; i<paras.length; i++) {
					System.out.print(paras[i].getName()+" arg ");
					if(i<paras.length-1) {
						System.out.print(",");
					}
				}
				System.out.println(")");
				Class excu[] = m.getExceptionTypes();
				for(int i = 0; i<excu.length; i++) {
					System.out.print(excu[i].getSimpleName());
					if(i<excu.length-1) {
						System.out.print(",");
					}
				}
				
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
