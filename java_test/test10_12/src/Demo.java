
public class Demo {
	public static void doit(int c) {
		switch(c) {
			case Seasons.SPRING:
			    System.out.println("��");
			    break;
			case Seasons.SUMMER:
				System.out.println("��");
				break;
			case Seasons.AUTUMN:
				System.out.println("��");
				break;
			case Seasons.WINTER:
				System.out.println("��");
				break;
		}
	}
	
	public static void doit2(Seasons2 s) {
		switch(s) {
		case SPRING:
			 System.out.println("��");
			    break;
		case SUMMER:
				System.out.println("��");
				break;
		case AUTUMN:
				System.out.println("��");
				break;
		case WINTER:
				System.out.println("��");
				break;
		}
	}
	
	public static void main1(String[] args) {
		//doit(Seasons.SPRING);
		//doit(100);
		doit2(Seasons2.SPRING);
		doit2(Seasons2.SUMMER);
		//doit(2);  ����
	}
	
	
	public static void main2(String[] args) {
		Constants enthumArray[] = Constants.values();
//		for(int i=0; i<enthumArray.length; i++) {
//			System.out.println("ö�����ͳ�Ա��ֵ�� "+enthumArray[i]);
//		}
		
		for(Constants tmp: enthumArray) {
			System.out.println("ö�����ͳ�Ա��ֵ�� "+tmp);
		}
	}

	
	public static void main(String[] args) {
		Constants c1 = Constants.Constants_A;
		Constants c2 = Constants.valueOf("Constants_A");
		System.out.println(c1 == c2);
	}
}

