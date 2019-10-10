
public class test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 30;
		int c= 20;
		int max = (a>b)? ((a>c)?a:c) : (b>c?b:c);
		int min = (a<b)? ((a<c)?a:c) : (b<c?b:c);
		System.out.println(max);
		System.out.println(min);
	}

}
