package com.company;

import java.io.*;
import java.util.Properties;

class En2Morse {
    String handle(BufferedReader reader) throws IOException {
        InputStream input = new FileInputStream("alphabet.txt");
        Properties alphabet = new Properties();
        try {
            alphabet.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader == null) {
            throw new IllegalArgumentException("\nText shouldn't be null.\n");
        }
        StringBuilder code = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                String text = line.toUpperCase();
                String codeString = text.substring(i, i + 1);
                String word = alphabet.getProperty(codeString);
                if (word == null) {
                    code.append("/");
                }
                else{
                    if ((word.equals(".-.-.-"))&&(alphabet.getProperty(text.substring(i+1, i + 2)) == null)) {
                        code.append(word);
                    }else {
                        if (word.equals("E"))
                            code.append(".-.-.-");
                        else
                            code.append(word + " ");
                    }
                }
            }
            code.append("/\n");
        }
        return code.toString();
    }
}