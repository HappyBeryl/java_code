import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		Set set = new TreeSet();
		Person p1 = new Person(1, 18, "小明");
		Person p2 = new Person(2, 5, "大壮");
        Person p3 = new Person(3, 20, "阿强");
        
        
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p3);  //重复的元素不会被添加到集合中
        System.out.println(set.size());
        
        Iterator it = set.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
		
	}
}
