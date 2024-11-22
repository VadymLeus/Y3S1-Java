package game;

import java.io.Serializable;

/**
 * Абстрактний клас {@code Participant} представляє учасника команди.
 * Реалізує інтерфейси {@link Cloneable}, {@link Comparable} і {@link Serializable}.
 */
public abstract class Participant implements Cloneable, Comparable<Participant>, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Ім'я учасника.
     */
    private String name;

    /**
     * Вік учасника.
     */
    private int age;

    /**
     * Створює учасника з вказаними іменем і віком.
     *
     * @param name Ім'я учасника.
     * @param age  Вік учасника.
     */
    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Повертає ім'я учасника.
     *
     * @return Ім'я учасника.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює ім'я учасника.
     *
     * @param name Нове ім'я учасника.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Повертає вік учасника.
     *
     * @return Вік учасника.
     */
    public int getAge() {
        return age;
    }

    /**
     * Встановлює вік учасника.
     *
     * @param age Новий вік учасника.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Створює глибоку копію об'єкта {@code Participant}.
     *
     * @return Клонований об'єкт {@code Participant}.
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
     * Порівнює об'єкти {@code Participant} за іменем.
     *
     * @param other Інший об'єкт {@code Participant} для порівняння.
     * @return Результат порівняння рядків (ім'я учасника).
     */
    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Повертає рядкове представлення об'єкта {@code Participant}.
     *
     * @return Рядкове представлення об'єкта {@code Participant}.
     */
    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Перевіряє рівність між цим і іншим об'єктом.
     *
     * @param obj Об'єкт для порівняння.
     * @return {@code true}, якщо об'єкти рівні; {@code false} — у протилежному випадку.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && name.equals(that.name);
    }

    /**
     * Повертає хеш-код для об'єкта {@code Participant}.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }
}
