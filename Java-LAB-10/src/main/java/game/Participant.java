package game;

import java.io.Serializable;

/**
 * Abstract class {@code Participant} represents a team participant.
 * Implements interfaces {@link Cloneable}, {@link Comparable}, and {@link Serializable}.
 */
public abstract class Participant implements Cloneable, Comparable<Participant>, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The name of the participant.
     */
    private String name;

    /**
     * The age of the participant.
     */
    private int age;

    /**
     * Creates a participant with the specified name and age.
     *
     * @param name The name of the participant.
     * @param age  The age of the participant.
     */
    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the participant.
     *
     * @return The name of the participant.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the participant.
     *
     * @param name The new name of the participant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the participant.
     *
     * @return The age of the participant.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the participant.
     *
     * @param age The new age of the participant.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Creates a deep copy of the {@code Participant} object.
     *
     * @return A cloned {@code Participant} object.
     */
    @Override
    public Participant clone() {
        try {
            return (Participant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for Participant", e);
        }
    }

    /**
     * Compares {@code Participant} objects by name.
     *
     * @param other Another {@code Participant} object to compare with.
     * @return The result of string comparison (participant name).
     */
    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Returns a string representation of the {@code Participant} object.
     *
     * @return A string representation of the {@code Participant} object.
     */
    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Checks equality between this and another object.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && name.equals(that.name);
    }

    /**
     * Returns the hash code for the {@code Participant} object.
     *
     * @return The hash code of the object.
     */
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }
}