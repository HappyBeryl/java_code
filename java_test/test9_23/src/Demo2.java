
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("�����ӳ�");
			int a = 1/0;
			System.out.println("����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("�ر����ӳ�");
		}
	}

}
