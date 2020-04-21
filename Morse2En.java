package com.company;

import java.io.*;
import java.util.Properties;

class Morse2En {

    public static String firstUpperCase(String text) {
            char[] myChars = text.toCharArray();
            char[] s = text.toUpperCase().toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (((text.charAt(i) == '.') || (text.charAt(i) == '!') || (text.charAt(i) == '?')) && ((i + 2) < text.length())) {
                myChars[i + 2] = s[i + 2];
                text = String.valueOf(myChars);
            }
            if (((i >= 1)) && (text.charAt(i) == 'i') && (text.charAt(i - 1) == ' ') && (text.charAt(i + 1) == ' ') && ((i + 2) < text.length())) {
                myChars[i] = s[i];
                text = String.valueOf(myChars);
            }
            if ((text.charAt(0) == 'i') && (text.charAt(1) == ' ')) {
                myChars[i] = s[i];
                text = String.valueOf(myChars);
            }
        }
        return text;
    }

    String handle(BufferedReader reader) throws IOException {
        InputStream input = new FileInputStream("alphabet.txt");
        Properties dictionaries = new Properties();
        try {
            dictionaries.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader == null) {
            throw new IllegalArgumentException("\nMorse shouldn't be null.\n");
        }
        StringBuilder decode = new StringBuilder();
        String decodeString = "";
        String line;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (decodeString.equals(".-.-.-")) {
                    String word = dictionaries.getProperty(decodeString);
                    decodeString = "";
                    decode.append(word);
                }
                if (line.charAt(i) != '/') {
                    if (line.charAt(i) != ' ') {
                        decodeString += String.valueOf(line.charAt(i));
                    } else {
                        String word = dictionaries.getProperty(decodeString);
                        if (word == null) {
                            String newString = decodeString.substring(1);
                            word = dictionaries.getProperty(newString);
                            decode.append(word);
                            decodeString = "";
                        } else {
                            decodeString = "";
                            decode.append(word);
                        }
                    }
                } else {
                    decode.append(' ');
                }
            }
          decode.append("\n");
        }
        return decode.toString();
    }
}