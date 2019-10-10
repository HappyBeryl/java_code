
public class Test5 {

	public static void main(String[] args) {
		int count = 0;
		for(int year=1000; year<=2000; year++) {
//			//判断世纪闰年
//			if(year%100 == 0) {
//				if(year%400 == 0) {
//					System.out.print(year+" ");
//				}
//			}else {
//			//判断普通闰年
//				if(year%4 == 0) {
//					System.out.print(year+" ");
//				}
//			}
			if((year%400 == 0)||((year%4 == 0) && (year%100 != 0))) {
				System.out.print(year+" ");
				count++;
			}
		}
		System.out.println(count);
	}

}
