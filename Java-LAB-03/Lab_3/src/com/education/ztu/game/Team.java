package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> implements Cloneable {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is winner!");
    }

    @Override
    public Team<T> clone() {
        try {
            Team<T> clonedTeam = (Team<T>) super.clone();
            clonedTeam.participants = new ArrayList<>();
            for (T participant : this.participants) {
                clonedTeam.participants.add((T) participant.clone());
            }
            return clonedTeam;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for Team", e);
        }
    }

    @Override
    public String toString() {
        return "Team{" + "name='" + name + '\'' + ", participants=" + participants + '}';
    }
}
