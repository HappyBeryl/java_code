
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("打开连接池");
			int a = 1/0;
			System.out.println("连接");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("关闭连接池");
		}
	}

}
