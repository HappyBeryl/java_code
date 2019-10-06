import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapText {
	public static void main(String[] args) {
		Map map = new HashMap();
		
		map.put("String", "×Ö·û´®");
		map.put("Object", new Object());
		map.put("int", "123");
		map.put("Êý×Ö", 123);
		map.put(1, "1");
		map.put(new Object(), new Object());
		map.put(null,null);
		
		System.out.println(map.size());
		
		Set set = map.keySet();
		Iterator it = set.iterator();
		while( it.hasNext()) {
			Object obj = it.next();
			System.out.println("key="+obj+" value:"+map.get(obj));
		}
}
}
