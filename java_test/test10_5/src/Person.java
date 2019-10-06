
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
			return -1;  //-1������Ĳ������ұ���ҪС
		}
		int diff = this.id-p.id;
		if(diff!=0) {
			diff = diff / Math.abs(diff); //��ֵ����������ľ���ֵ
		}
		return diff;
	}

}
