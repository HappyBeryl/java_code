
public class frogJump {

	public static int frogjump(int n) {
		if(n == 1 || n==2) {
			return n;
		}
//		int f1 = 1;
//		int f2 = 2;
//		int f3 = 0;
//		for(int i=3; i<=n; i++) {
//			f3 = f2+f1;
//			f1 = f2;
//			f2 = f3;
//		}
//		return f3;
		return  frogjump(n-1)+ frogjump(n-2);
	}
	
	public static void main(String[] args) {
		int ret = frogjump(5); 
		System.out.println("共有"+ret+"种跳法");
	}

}
