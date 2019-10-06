import java.util.*;

public class Muster {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		System.out.println("集合是空的吗"+c.isEmpty()+"集合的长度"+c.size());
		c.add("你好");
		c.add(3.14);
		c.add(new Object());
		System.out.println("集合是空的吗"+c.isEmpty()+"集合的长度"+c.size());
		
		c.remove(3.14);
		
		Iterator it = c.iterator(); //迭代 遍历集合中的元素 一一输出
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
}
