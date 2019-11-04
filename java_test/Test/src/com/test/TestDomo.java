package com.test;

import com.test.MyArrayList;

public class TestDomo {
    public static void main(String[] args) {
        MyArrayList myArrayListr = new MyArrayList();
        myArrayListr.add(0,1);
        myArrayListr.add(1,2);
        myArrayListr.add(2,3);
        myArrayListr.add(3,4);
        boolean ret = myArrayListr.contains(4);
        System.out.println(ret);
        int ret2 = myArrayListr.search(2);
        System.out.println(ret2);
        myArrayListr.display();

    }

}
