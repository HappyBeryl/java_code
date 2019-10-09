
public class Example {
	int id;
	String name;
	double price;
	
	public Example() {
		super();
	}
	
	public Example(int id) {
		super();
		this.id = id;
	}
	
	private Example(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	

}
