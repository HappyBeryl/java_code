
public class Demo {
	public static void main(String[] args) {
		try {
			int a = 1/0;
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("发生了数据异常");
		}
	}

}
