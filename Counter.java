package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Counter {
    public static String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString().toLowerCase();
    }

    void statistic(String name) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(name));
        String text = readAllLines(reader).toLowerCase();
        FileWriter writer = new FileWriter("Statistic");
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alpha.length(); i++){
            char letter = alpha.charAt(i);
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int j = 0; j < text.length(); ++j) {
                char c = text.charAt(j);
                if (Character.isLetter(c)) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            if (map.get(letter) == null){
                writer.write("Число повторов буквы "+ letter+" - "+ "0" + "\n");
            }
            else{
                writer.write("Число повторов буквы "+ letter+" - "+map.get(letter) + "\n");
            }
        }
        writer.close();
    }
}