import java.util.Scanner;
public class test2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); //��������
	int age = sc.nextInt();
	if(age <= 18) {
		System.out.println("����");
	}else if(age <= 28) {
		System.out.println("����");
	}else if(age <= 55) {
		System.out.println("����");
	}else {
		System.out.println("����");
	}
}
}
