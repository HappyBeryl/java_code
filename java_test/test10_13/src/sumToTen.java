
public class sumToTen {

	public static int Sum(int n) {
		if(n == 1) {
			return 1;
		}
		return n+Sum(n-1);
	}
	
	public static void main(String[] args) {
		int ret = Sum(5);
		System.out.println(ret);
	}

}
