import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo1 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("Example1");
			Field[] fs = c.getDeclaredFields(); //返回所以属性
			for(Field f: fs) {
				System.out.print(Modifier.toString(f.getModifiers())+" "); //修饰符
				System.out.print(f.getType().getSimpleName()+" ");  //成员变量类型
				System.out.print(f.getName()); //成员变量名字
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
