package com.education.ztu;

import java.util.ArrayDeque;

public class MainQueue {
    public static void main(String[] args) {
        ArrayDeque<Product> queue = new ArrayDeque<>();
        queue.push(new Product("Juice", 2.30));
        queue.offerLast(new Product("Chocolate", 1.70));

        System.out.println("First: " + queue.getFirst());
        System.out.println("Peek Last: " + queue.peekLast());
        queue.pop();
        System.out.println("After pop: " + queue);

        queue.removeLast();
        System.out.println("After removeLast: " + queue);
    }
}
