package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас Team представляє команду учасників певного типу.
 *
 * @param <T> Тип учасників команди, який розширює {@link Participant}.
 */
public class Team<T extends Participant> implements Serializable, Cloneable {
    private static final Logger logger = LogManager.getLogger(Team.class);
    private static final long serialVersionUID = 1L;

    /**
     * Назва команди.
     */
    private String name;

    /**
     * Список учасників команди.
     */
    private List<T> participants = new ArrayList<>();

    /**
     * Створює команду з вказаною назвою.
     *
     * @param name Назва команди.
     */
    public Team(String name) {
        this.name = name;
        logger.info("Команда {} створена", name);
    }

    /**
     * Додає нового учасника до команди.
     *
     * @param participant Учасник, який додається.
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        logger.debug("Додано учасника {} до команди {}", participant.getName(), name);
    }

    /**
     * Здійснює змагання між двома командами.
     *
     * @param team Інша команда, з якою відбувається гра.
     */
    public void playWith(Team<T> team) {
        logger.info("Команда {} грає проти команди {}", this.name, team.name);
    }

    /**
     * Створює клон команди з глибокою копією списку учасників.
     *
     * @return Клонована команда.
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
            logger.info("Клонована команда {}", this.name);
            return clonedTeam;
        } catch (CloneNotSupportedException e) {
            logger.error("Помилка клонування команди {}", this.name, e);
            throw new RuntimeException("Clone not supported for Team", e);
        }
    }

    /**
     * Повертає рядкове представлення команди.
     *
     * @return Рядкове представлення команди.
     */
    @Override
    public String toString() {
        return "Team{" + "name='" + name + '\'' + ", participants=" + participants + '}';
    }
}
