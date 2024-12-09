package com.education.ztu;

import java.util.TreeSet;

public class MainSet {
    public static void main(String[] args) {
        TreeSet<Product> set = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        set.add(new Product("Banana", 0.60));
        set.add(new Product("Apple", 0.40));
        set.add(new Product("Orange", 0.80));

        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("HeadSet (Apple): " + set.headSet(new Product("Apple", 0.40)));
        System.out.println("SubSet (Apple to Banana): " + set.subSet(new Product("Apple", 0.40), new Product("Banana", 0.60)));
    }
}
