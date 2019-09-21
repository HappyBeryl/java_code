

public class Demo2 {
	public OutInterface action(String x){
		class innerClass2 implements OutInterface{
			public innerClass2(String s) {
			s = x;
			System.out.println(s);
		 }
		}
		return new innerClass2("do");
	}
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		d.action("局部内部类");
	}
}
interface OutInterface{
	
}