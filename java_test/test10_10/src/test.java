
public class test {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("a的值为："+a);
		System.out.println("b的值为： "+b);
		int tmp = 0;
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("交换后a的值为："+a);
		System.out.println("交换后b的值为："+b);
	}
}
