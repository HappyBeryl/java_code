
public abstract class Bird extends Animal {
	String feather;//��ë
	public Bird(String feather) {
	  System.out.println("������һ������");
	  this.feather = feather;
	}
	
	public void growFeather() {
		System.out.println("����" +feather+ "��ë");
	}
	
	abstract public void move();

    public void reproduce() {
    	System.out.println("�µ�");
    }
}
