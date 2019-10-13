
public class sumPrintBit {

	public static int SumPrint(int n) {
		if(n<10) {
			return n;
		}
		return n%10+SumPrint(n/10);
	}
	
	public static void main(String[] args) {
		int ret = SumPrint(123);
		System.out.println(ret);
	}
}
