package com.education.ztu;

import java.util.HashMap;
import java.util.Map;

public class MainMap {
    public static void main(String[] args) {
        HashMap<String, Product> map = new HashMap<>();
        map.put("TV", new Product("TV", 300.00));
        map.put("Laptop", new Product("Laptop", 800.00));

        System.out.println("Get TV: " + map.get("TV"));
        System.out.println("Contains Key 'Laptop': " + map.containsKey("Laptop"));
        System.out.println("Contains Value (Laptop): " + map.containsValue(new Product("Laptop", 800.00)));

        for (Map.Entry<String, Product> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
