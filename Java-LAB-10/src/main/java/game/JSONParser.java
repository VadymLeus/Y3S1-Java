package game;

import com.google.gson.Gson;
import game.Participant;
import game.Schoolar;
import game.Team;

public class JSONParser {

    public static void main(String[] args) {
        Gson gson = new Gson();

        // Створення об'єкту Java
        Team<Participant> team = new Team<>("Dragon");
        team.addNewParticipant(new Schoolar("Ivan", 13));
        team.addNewParticipant(new Schoolar("Mariya", 15));

        // Перетворення Java-об'єкту у JSON
        String json = gson.toJson(team);
        System.out.println("JSON Representation:");
        System.out.println(json);

        // Перетворення JSON у Java-об'єкт
        Team deserializedTeam = gson.fromJson(json, Team.class);
        System.out.println("\nDeserialized Team:");
        System.out.println(deserializedTeam);
    }
}