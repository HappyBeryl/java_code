 import java.util.Scanner;
public class Test{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int ret = Print(input);
		System.out.print(ret);
		
	}
}
	//伴鱼 读我科技
	
	public static int Print(int n) {
		if(n<10) {
			return n;
		}
		return n%10+Print(n/10);
	}
}