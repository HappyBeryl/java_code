package com.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestArraysortAndCollectionsort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.sort(list);
    }
}
