
public class Test3 {
	public static void main(String[] args) {
		int a = 11;
		int i = 2;
		while(i < a) {
			if(a%i == 0) {
				break;	
			}
			i++;
		}
		if(i == a) {
			System.out.println("������");
		}else {
			System.out.println("��������");
		}
	}
}
