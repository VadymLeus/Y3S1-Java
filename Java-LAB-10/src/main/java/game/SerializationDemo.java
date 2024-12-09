package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class SerializationDemo {
    private static final Logger logger = LogManager.getLogger(SerializationDemo.class);

    public static void main(String[] args) {
        logger.info("The beginning of serialisation...");
        Schoolar schoolar = new Schoolar("Ivan", 13);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("schoolar.ser"))) {
            oos.writeObject(schoolar);
            logger.debug("Object {} is serialised", schoolar.getName());
        } catch (IOException e) {
            logger.error("Serialisation error", e);
        }

        logger.info("The beginning of deserialisation...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("schoolar.ser"))) {
            Schoolar deserializedSchoolar = (Schoolar) ois.readObject();
            logger.debug("Object {} deserialised", deserializedSchoolar.getName());
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Deserialisation error", e);
        }
    }
}
