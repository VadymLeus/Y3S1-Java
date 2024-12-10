package Task_04;
import java.io.*;

public class FileCopier {

    public static void copyTextFile(String sourcePath, String destinationPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("The text file was copied successfully.");

        } catch (IOException e) {
            System.out.println("Error copying a text file: " + e.getMessage());
        }
    }

    public static void copyBinaryFile(String sourcePath, String destinationPath) {
        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             FileOutputStream outputStream = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("The binary file has been copied successfully.");

        } catch (IOException e) {
            System.out.println("Error copying a binary file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String textSource = "Java-LAB-06/src/directory_for_files/receipt.txt";
        String textDestination = "Java-LAB-06/src/directory_for_files/receipt_copy.txt";
        copyTextFile(textSource, textDestination);

        String imageSource = "Java-LAB-06/src/directory_for_files/image.jpg";
        String imageDestination = "Java-LAB-06/src/directory_for_files/image_copy.jpg";
        copyBinaryFile(imageSource, imageDestination);
    }
}
