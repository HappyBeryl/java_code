package com.map;

import com.sun.xml.internal.fastinfoset.stax.events.StAXFilteredEvent;

import java.util.*;

public class TestDemo {
//迭代器遍历map
public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("hh",1);
    map.put("haha",2);
    Set<Map.Entry<String, Integer>> set = map.entrySet();
    Iterator<Map.Entry<String, Integer>> iterable =  set.iterator();
    while (iterable.hasNext()) {
        System.out.println(iterable.next());
    }
}
}
