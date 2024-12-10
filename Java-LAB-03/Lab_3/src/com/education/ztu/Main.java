package com.education.ztu;

import com.education.ztu.game.*;

public class Main {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);

        Team<Schoolar> schoolarTeam = new Team<>("Dragon");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        System.out.println("Original team: " + schoolarTeam);

        Team<Schoolar> clonedTeam = schoolarTeam.clone();
        System.out.println("Cloned team: " + clonedTeam);

        System.out.println("Equals: " + schoolar1.equals(schoolar2));
        System.out.println("HashCode of schoolar1: " + schoolar1.hashCode());
        System.out.println("HashCode of schoolar2: " + schoolar2.hashCode());
    }
}
