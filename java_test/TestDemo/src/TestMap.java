import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        //重复只显示一次
        map.put(1,"a");
        map.put(3,"c");
        map.put(2,"b");
        System.out.println(map);
        System.out.println(map.get(2));
        //返回null
        System.out.println(map.get(99));

        //打印所有的key
        for(Integer key : map.keySet()) {
            System.out.println(key);
        }

        //打印所有的value
        for(String value: map.values()) {
            System.out.println(value);
        }

        //按key-value的映射关系dayin
        for(Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
