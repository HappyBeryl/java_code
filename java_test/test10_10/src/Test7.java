
public class Test7 {

	public static void main(String[] args) {
		int a = 50;
		int b = 10;
		int y = 0;
		while(a%b != 0) {
			y = a%b;
			a = b;
			b = y;
		}
		System.err.println(b);
	}
}
