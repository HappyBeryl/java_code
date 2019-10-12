import java.awt.HeadlessException;

public class Demo2<T> {
	T over;

	public T getOver() {
		return over;
	}

	public void setOver(T over) {
		this.over = over;
	}
	
	public static void main(String[] args) {
		Demo2<Boolean> d1 = new Demo2<>();
		//为别的类型会报错
		d1.setOver(true);
		boolean b = d1.getOver();
	}
}
