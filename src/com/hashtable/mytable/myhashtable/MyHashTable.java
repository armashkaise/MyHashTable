package com.hashtable.mytable.myhashtable;

import java.util.Objects;

public class MyHashTable {

    Node[] array;
    int size;
    static int COUNT_APACITY = 2;

    public MyHashTable() {
        array = new Node[COUNT_APACITY];
    }

    public void put(Object key, Object element){
        if (size > 0 && size == array.length) {
            Node[] newArray = new Node[size * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
            array[size] = new Node(key, element);
            size++;
    }

    public Object get(Object key){
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

    public boolean remove(Object key){
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

    private int findElement(Object key){
        int nom = 0;
        for (Node ar : array){
            if (ar.getKey() == key) {
                return nom;
            }
            nom++;
        }
        return -1;
    }



    private class Node{
        private Object key;
        private Object element;

        public Node(Object key, Object element) {
            this.key = key;
            this.element = element;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "ключ = " + key +
                    ", значение = " + element;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}


