package com.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

class HashBack<K,V> {
    static class Node<K,V> {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V>[] array = (Node<K,V>[])new Node[8]; //存放单链表的头节点
    private int size; //当前数据的个数

    public void put(K key,V value) {
        //int index = key % array.length;
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % array.length;
        for(Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if(cur.key.equals(key)) {
                cur.value = value;
                return;
            }
        }
        //头插法
        Node<K,V> node = (Node<K,V>)new Node(key,value);
        node.next = array[index];
        array[index] = node;

        this.size++;
    }

    public V getValue(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % array.length;

        Node<K,V> head = array[index];
        for(Node<K,V> cur = head;cur != null;cur = cur.next) {
            if(cur.key.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }



}

public class TestDemo2 {
    public static void main(String[] args) {
        Person person = new Person("bq",18);
        Person person2 = new Person("bq",18);
        //key是name 如果key值相同 哈希地址应该相同
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());

        HashBack<Person, String> hashBack = new HashBack<>();
        hashBack.put(person, "06171088");

        String id = hashBack.getValue(person2);
        System.out.println(id);

    }
}
