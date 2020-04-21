package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public final class Main {

    public static void main(String args[]) throws FileNotFoundException {
            Counter COUNT = new Counter();
            System.out.println("What are you want: Code En2M / Decode M2En ? ");
            Scanner keyboard = new Scanner(System.in);
            String act = keyboard.next();
            if (act.equals("code")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("TheBlackCat.txt"));
                    FileWriter writer = new FileWriter("CODETheBlackCat.txt");
                    COUNT.statistic("TheBlackCat.txt");
                    En2Morse E2M = new En2Morse();
                    writer.write(E2M.handle(reader));
                    reader.close();
                    writer.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("CODETheBlackCat.txt"));
                    FileWriter writer = new FileWriter("DECODECODETheBlackCat.txt");
                    Morse2En M2E = new Morse2En();
                    writer.write(Morse2En.firstUpperCase(M2E.handle(reader).toLowerCase()));
                    reader.close();
                    writer.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                } catch (IOException e) {
                    e.printStackTrace();
                };
            }
        }
    }
