
public class Person implements Comparable{
	int id;
	int age;
	String name;
	
	public Person(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

	public int compareTo(Object o) {
		Person p;
		if(o instanceof Person) {
			p=(Person)o;
		}else {
			return -1;  //-1代表传入的参数比我本身要小
		}
		int diff = this.id-p.id;
		if(diff!=0) {
			diff = diff / Math.abs(diff); //差值除以它本身的绝对值
		}
		return diff;
	}

}
