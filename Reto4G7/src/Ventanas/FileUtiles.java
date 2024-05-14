package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FileUtiles {

    public static File getMostRecentFile(String directory, String extension) {
        File dir = new File(directory);
        File[] files = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith("." + extension));
        if (files == null || files.length == 0) {
            return null;
        }

        File mostRecentFile = files[0];
        long mostRecentTime = mostRecentFile.lastModified();

        for (File file : files) {
            if (file.lastModified() > mostRecentTime) {
                mostRecentFile = file;
                mostRecentTime = file.lastModified();
            }
        }

        return mostRecentFile;
    }

    public static String readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void displayFileContents(String fileContents, JTextArea textArea) {
        SwingUtilities.invokeLater(() -> textArea.setText(fileContents));
    }
}
