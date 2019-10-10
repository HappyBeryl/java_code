
public class Test4 {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			int j = 2;
			while(j <= i) {
				if(i%j == 0) {
					break;
				}
				j++;
			}
			if(i == j) {
				System.out.print(i+" ");
			}
		}
	}
}
