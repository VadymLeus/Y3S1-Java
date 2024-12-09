package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Team class represents a team of participants of a specific type.
 *
 * @param <T> The type of participants in the team, which extends {@link Participant}.
 */
public class Team<T extends Participant> implements Serializable, Cloneable {
    private static final Logger logger = LogManager.getLogger(Team.class);
    private static final long serialVersionUID = 1L;

    /**
     * The name of the team.
     */
    private String name;

    /**
     * The list of participants in the team.
     */
    private List<T> participants = new ArrayList<>();

    /**
     * Creates a team with the specified name.
     *
     * @param name The name of the team.
     */
    public Team(String name) {
        this.name = name;
        logger.info("Team {} created", name);
    }

    /**
     * Adds a new participant to the team.
     *
     * @param participant The participant to be added.
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        logger.debug("Added participant {} to team {}", participant.getName(), name);
    }

    /**
     * Conducts a competition between two teams.
     *
     * @param team The other team to compete with.
     */
    public void playWith(Team<T> team) {
        logger.info("Team {} is playing against team {}", this.name, team.name);
    }

    /**
     * Creates a clone of the team with a deep copy of the participants list.
     *
     * @return The cloned team.
     */
    @Override
    public Team<T> clone() {
        try {
            @SuppressWarnings("unchecked")
            Team<T> clonedTeam = (Team<T>) super.clone();
            clonedTeam.participants = new ArrayList<>();
            for (T participant : this.participants) {
                clonedTeam.participants.add((T) participant.clone());
            }
            logger.info("Cloned team {}", this.name);
            return clonedTeam;
        } catch (CloneNotSupportedException e) {
            logger.error("Error cloning team {}", this.name, e);
            throw new RuntimeException("Clone not supported for Team", e);
        }
    }
    /**
     * Returns the string representation of the team.
     *
     * @return The string representation of the team.
     */
    @Override
    public String toString() {
        return "Team{" + "name='" + name + '\'' + ", participants=" + participants + '}';
    }
}