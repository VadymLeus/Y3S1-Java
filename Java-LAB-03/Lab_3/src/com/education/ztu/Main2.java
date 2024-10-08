package com.education.ztu;

import com.education.ztu.game.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Schoolar schoolar3 = new Schoolar("Sergey", 12);

        List<Schoolar> schoolars = new ArrayList<>();
        schoolars.add(schoolar1);
        schoolars.add(schoolar2);
        schoolars.add(schoolar3);

        Collections.sort(schoolars);
        System.out.println("Sorted by name: " + schoolars);

        Collections.sort(schoolars, new AgeComparator());
        System.out.println("Sorted by age: " + schoolars);
    }
}
