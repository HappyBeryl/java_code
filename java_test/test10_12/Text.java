public class Text {
	
	 public static int Jump(int n) {
		 if(n==1 || n==2) {
			 return n;
		 }
		 return Jump(n-1)+Jump(n-2);
	 }
 }
	 
	public static void main(String[] args) {
		int ret = Jump(4);
		System.out.println(ret);
	}





