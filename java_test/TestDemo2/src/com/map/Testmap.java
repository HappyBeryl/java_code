package com.map;

import java.util.*;

public class Testmap {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"abc");
        map.put(10,"hello");
        map.put(null,"haha"); //key可以为null
        String s = map.get(10);
        s = map.getOrDefault(40,"hhhhh");
        System.out.println(map);
        System.out.println(s);

        String s1 = map.remove(10);
        System.out.println(s1);
        System.out.println(map);

        Set<Integer> set = map.keySet();
        System.out.println(set);

        Collection<String> collection =  map.values();
        System.out.println(collection);
        //Set<Map.Entry<K, V>>  -> Map.Entry<K, V>
        //int[] array    ->           int
        for ( Map.Entry<Integer, String> entrySet  :   map.entrySet()) {
            System.out.println(entrySet.getKey()+" "+entrySet.getValue());
        }
    }
}
