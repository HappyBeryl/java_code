
public class Demo3  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String player = "monkey";
		try {
			if(!player .equals("human")) {
				throw new NonHuman("有非人类"+player);
			}
			else {
				System.out.println("比赛");
			}
		} catch (NonHuman e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

