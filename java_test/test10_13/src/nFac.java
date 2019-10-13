
public class nFac {
	
	public static int Fac(int n) {
		if(n == 1) {
			return 1;
		}
		return n*Fac(n-1);
	}

	public static void main(String[] args) {
		int ret = Fac(5);
		System.out.println(ret);
	}

}
