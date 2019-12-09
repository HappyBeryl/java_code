import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Java");
        collection.add("Hello");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);
        collection.remove("Java");
//        boolean add(E e); //将元素e放入集合中
//        void clear(); //删除集合中所有元素
//        boolean isEmpty(); //判断集合是否为空
//        boolean remove(Object e); //如果元素e出现在集合中，删除其中一个
//        int size(); //返回集合中元素个数
//        Object[] toArray(); //返回一个装有所有集合中元素的数组
    }

}
