
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seagull jack = new Seagull("��ɫ");
		jack.eat();
		jack.move();
		jack.growFeather();
		jack.reproduce();
		System.out.println();
		Chick gege = new Chick("��ɫ");
		gege.eat();
		gege.move();
		gege.growFeather();
		jack.reproduce();
	}

}
