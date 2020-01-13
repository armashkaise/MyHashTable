package com.hashtable.mytable;

import com.hashtable.mytable.myhashtable.MyHashTable;

public class Main {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable();
        User user1 = new User("User1", 1981);
        User user2 = new User("User2", 1982);
        User user3 = new User("User3", 1983);
        User user4 = new User("User4", 1984);
        User user5 = new User("User5", 1985);
//добавление элементов
        hashTable.put("stroka1", user1);
        hashTable.put("stroka2", user2);
        hashTable.put("stroka3", user3);
        hashTable.put("stroka4", user4);
        hashTable.put("stroka5", user5);
//поиск элеметов по ключу
        System.out.println(hashTable.get("stroka3"));
        System.out.println(hashTable.get("stroka5"));
//удаление элемента
        System.out.println(hashTable.size());;
        if(hashTable.remove("stroka3")) System.out.println(hashTable.size());;

        System.out.println(hashTable.get("stroka3"));
    }

}
