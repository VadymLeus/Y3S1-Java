package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class SerializationDemo {
    private static final Logger logger = LogManager.getLogger(SerializationDemo.class);

    public static void main(String[] args) {
        logger.info("Початок серіалізації...");
        Schoolar schoolar = new Schoolar("Ivan", 13);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("schoolar.ser"))) {
            oos.writeObject(schoolar);
            logger.debug("Об'єкт {} серіалізовано", schoolar.getName());
        } catch (IOException e) {
            logger.error("Помилка серіалізації", e);
        }

        logger.info("Початок десеріалізації...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("schoolar.ser"))) {
            Schoolar deserializedSchoolar = (Schoolar) ois.readObject();
            logger.debug("Об'єкт {} десеріалізовано", deserializedSchoolar.getName());
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Помилка десеріалізації", e);
        }
    }
}
