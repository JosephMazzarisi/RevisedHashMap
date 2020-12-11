package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        MyHashMap hashMap = new MyHashMap();
        //System.out.println("hashMap is empty: "+hashMap.isEmpty());
        System.out.println(hashMap.size());
        hashMap.put("Dog", "Bowwow");
        hashMap.put("EA", "Sports");
        hashMap.put("It's", "In");
        hashMap.put("The", "Game");
        hashMap.putIfAbsent("Dog","Bark");
        System.out.println(hashMap.getOrDefault("Dog","Meow"));
        System.out.println("Size Test: " + hashMap.size());
    hashMap.display();
    }
}
