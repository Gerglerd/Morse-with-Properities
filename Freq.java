package com.company;
import java.io.*;
import java.util.*;

public class Freq {
    public static String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString().toLowerCase();
    }

    public static void statistic(String name, String newName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(name));
        String text = readAllLines(reader).toLowerCase();
        FileWriter writer = new FileWriter(newName);
        List<String> newText = new ArrayList<String> ();
        ArrayList<Integer> counter = new ArrayList<Integer>();
        for (int i = 0 ; i < text.length() ; i++) {
            if (Character.isLetter(text.charAt(i))) {
                newText.add(Character.toString(text.charAt(i)));
            }
        }
        HashSet<String> unique = new HashSet<String>(newText);
        for(String s:unique) {
            counter.add(Collections.frequency(newText, s));
            writer.write(s + " - "+Collections.frequency(newText, s) + "\n");
        }
        writer.close();
        reader.close();
    }

}