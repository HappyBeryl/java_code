
public class Demo {
	innerClass in = new innerClass();
	public void outf() {
		in.inf();
	}
	
	class innerClass{
		int y = 0;
		public innerClass() {
		}
		
		public void inf() {
			System.out.println("�����ڲ��෽��");
		}
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		d.outf();
		Demo.innerClass in = d.new innerClass();
		in.inf();
		}

}
