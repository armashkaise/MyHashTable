package com.hashtable.mytable;

import com.hashtable.mytable.myhashtable.MyHashTable;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {



        MyHashTable hashTable = new MyHashTable(20);
        String userName1 = "User1";
        String userName2 = "User2";
        String userName3 = "User3";
        String userName4 = "User4";
        String userName5 = "User5";
        User user1 = new User(userName1, 1981);
        User user2 = new User(userName2, 1982);
        User user3 = new User(userName3, 1983);
        User user4 = new User(userName4, 1984);
        User user5 = new User(userName5, 1985);
//добавление элементов
        hashTable.put(userName1, user1);
        hashTable.put(userName2, user2);
        hashTable.put(userName3, user3);
        hashTable.put(userName4, user4);
        hashTable.put(userName1, user5);
//поиск элеметов по ключу
        System.out.println(hashTable.get(userName3));
        System.out.println(hashTable.get(userName5));
//удаление элемента
        System.out.println(hashTable.size());;
        if(hashTable.remove(userName3)) System.out.println(hashTable.size());;

        System.out.println(hashTable.get(userName3));
    }

}
