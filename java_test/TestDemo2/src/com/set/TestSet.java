package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);

        //迭代器->只要实现了iterable接口
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
