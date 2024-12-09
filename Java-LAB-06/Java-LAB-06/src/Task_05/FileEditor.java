package Task_05;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileEditor {

    public static void insertTextAtLinePositions(String filePath, int[] lineNumbers, String[] texts) {
        if (lineNumbers.length != texts.length) {
            System.out.println("Error: The number of items and texts do not match.");
            return;
        }
        try {
            List<String> fileLines = Files.readAllLines(Paths.get(filePath));
            List<Integer> sortedLineNumbers = new ArrayList<>();
            for (int pos : lineNumbers) sortedLineNumbers.add(pos);
            sortedLineNumbers.sort(Integer::compareTo);

            int offset = 0;
            for (int i = 0; i < texts.length; i++) {
                int insertLine = lineNumbers[i] + offset;
                if (insertLine >= 0 && insertLine < fileLines.size()) {
                    fileLines.add(insertLine, texts[i]);
                    offset++;
                } else {
                    System.out.println("Error: string " + insertLine + " doesn't exist in the file.");
                }
            }

            Files.write(Paths.get(filePath), fileLines);
            System.out.println("The text was successfully added to the specified rows.");

        } catch (IOException e) {
            System.out.println("Error while working with the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "Java-LAB-06/src/directory_for_files/receipt.txt";
        int[] lineNumbers = {3, 5, 7};
        String[] texts = {
                "Новий товар: Штани, 1000 ₴",
                "Новий товар: Капелюх, 500 ₴",
                "Новий товар: Рукавички, 300 ₴"
        };
        insertTextAtLinePositions(filePath, lineNumbers, texts);
    }
}
