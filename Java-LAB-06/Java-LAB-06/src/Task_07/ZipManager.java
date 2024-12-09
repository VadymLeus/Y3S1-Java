package Task_07;
import java.io.*;
import java.util.zip.*;

public class ZipManager {

    private static final String ZIP_FILE = "Java-LAB-06/src/archive.zip";
    public static void main(String[] args) {
        File directory = new File("Java-LAB-06/src/directory_for_files");
        try {
            createZip(directory);
            System.out.println("The files have been successfully added to the archive.");
            listFilesInZip(ZIP_FILE);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void createZip(File directory) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE))) {
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            addFileToZip(file, zos);
                        }
                    }
                }
            } else {
                System.out.println("Folder not found.");
            }
        }
    }
    private static void addFileToZip(File file, ZipOutputStream zos) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            System.out.println("Added to the archive: " + file.getName());
        }
    }
    public static void listFilesInZip(String zipFile) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            System.out.println("The contents of the archive:");
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(" - " + entry.getName());
                zis.closeEntry();
            }
        }
    }
}
