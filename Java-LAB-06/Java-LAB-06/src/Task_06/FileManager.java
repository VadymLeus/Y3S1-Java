package Task_06;
import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void main(String[] args) {
        try {
// 1.
            File innerDirectory = new File("Java-LAB-06/src/inner_directory");
            if (innerDirectory.mkdir()) {
                System.out.println("Folder created: " + innerDirectory.getName());
            } else {
                System.out.println("Folder creation failed.");
            }
// 2.
            System.out.println("Absolute path: " + innerDirectory.getAbsolutePath());

// 3.
            String parent = innerDirectory.getParent();
            System.out.println("The name of the parent directory: " + parent);
// 4.
            File file1 = new File(innerDirectory, "file1.txt");
            File file2 = new File(innerDirectory, "file2.txt");
            if (file1.createNewFile() && file2.createNewFile()) {
                System.out.println("The files are created: " + file1.getName() + ", " + file2.getName());
            } else {
                System.out.println("Failed to create files.");
            }
// 5.
            if (file2.delete()) {
                System.out.println("The file has been deleted: " + file2.getName());
            } else {
                System.out.println("Couldn't get the file.");
            }
// 6.
            File renamedDirectory = new File("Java-LAB-06/src/renamed_inner_directory");
            if (innerDirectory.renameTo(renamedDirectory)) {
                System.out.println("The folder is renamed to: " + renamedDirectory.getName());
            } else {
                System.out.println("The folder could not be renamed.");
            }
// 7.
            File directoryForFiles = new File("Java-LAB-06/src/directory_for_files");
            if (directoryForFiles.exists() && directoryForFiles.isDirectory()) {
                File[] files = directoryForFiles.listFiles();
                if (files != null) {
                    System.out.println("Contents of the folder " + directoryForFiles.getName() + ":");
                    for (File f : files) {
                        String type = f.isDirectory() ? "Folder" : "File.";
                        System.out.printf("%s - %s, Size.: %d byte%n", f.getName(), type, f.length());
                    }
                } else {
                    System.out.println("The folder is empty.");
                }
            } else {
                System.out.println("The directory_for_files folder does not exist.");
            }

        } catch (IOException e) {
            System.out.println("There was an error:" + e.getMessage());
        }
    }
}
