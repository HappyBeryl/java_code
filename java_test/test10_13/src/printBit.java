
public class printBit {

	public static void Print(int n) {
		if(n > 9) {
			Print(n/10);
		}
		System.out.print(n%10+" ");
	}
	
	public static void main(String[] args) {
		Print(1234);
	}
}
