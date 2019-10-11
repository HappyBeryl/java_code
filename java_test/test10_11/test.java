public class test {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=5; i++) {
			int t = 1;
			for(int j=1; j<=i; j++) {
				t *= j;
			}
			sum += t;
		}
		System.out.println(sum);
	}
}