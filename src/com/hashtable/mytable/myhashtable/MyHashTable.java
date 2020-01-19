package com.hashtable.mytable.myhashtable;

import java.util.Arrays;
import java.util.Objects;

public class MyHashTable {

    Node[] array;
    int size = 0;
    static int CAPACITY = 16;

    public MyHashTable() {
        array = new Node[CAPACITY];
    }

    public MyHashTable(int newCapacity) {
        if (newCapacity > 0) CAPACITY = newCapacity;
        array = new Node[CAPACITY];
    }

    public void put(String key, Object element){
        if (size > 0 && size == array.length) {
            resizeArray();
        }
        int hash = hash(key);

        int n = CAPACITY;
        int index = (n - 1) & hash;
            if (array[index] == null) {
                array[index] = new Node(hash, key, element);
                size++;
            }
            else if (hash == array[index].hash || key.equals(array[index].key)){
                array[index].next = new Node(hash, key, element);
            }

    }

    private void resizeArray(){
        CAPACITY = size * 2;
        Node[] newArray = new Node[CAPACITY];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public static int hash(String key){
        int h = 0;
        if (key == null) return 0;
         h = key.hashCode() ^ (h >>> 16);
        return h;
    }

    public Object get(String key){
        try {
            for (Node ar : array){
                if (ar.getKey() == key) {
                    return ar.getElement();
                }
            }
        } catch (NullPointerException e){

        }    return "Значениe ключа " + key + " не найдено";
    }

    public int size() {
        return size;
    }

    public boolean remove(String key){
         //nomElement = -1;
        int nomElement = findElement(key);
        if (nomElement >= 0){
            Node[] newArrayFirst = new Node[nomElement];
            Node[] newArrayLast = new Node[size - nomElement];
            Node[] newArray = new Node[size--];
            System.arraycopy(array, 0, newArrayFirst, 0, nomElement);
            System.arraycopy(array, nomElement + 1, newArrayLast, 0, newArrayLast.length);
            System.arraycopy(newArrayFirst, 0, array, 0, newArrayFirst.length);
            System.arraycopy(newArrayLast, 0, array, newArrayFirst.length, newArrayLast.length);
            return true;
        }
        return false;
    }

    private int findElement(String key){
        int nom = 0;
        for (Node ar : array){
            if (ar.getKey() == key) {
                return nom;
            }
            nom++;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashTable hashTable = (MyHashTable) o;
        return size == hashTable.size &&
                Arrays.equals(array, hashTable.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

   /* private class Key{
        String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return Objects.equals(key, key1.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }*/

    private class Node {
        private int hash;
        private String key;
        private Object element;
        private Node next;

        public Node(int hash, String key, Object element) {
            this.hash = hash;
            this.key = key;
            this.element = element;
            this.next = null;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}


