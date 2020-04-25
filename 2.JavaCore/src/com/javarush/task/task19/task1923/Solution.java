package com.javarush.task.task19.task1923;
import java.io.*;
/* 
Слова с цифрами
*/

public class Solution {
     public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] listWords = temp.split(" ");
                for (int i = 0; i < listWords.length; i++) {
                    if (listWords[i].matches("[\\w\\p{P}]*\\d+[\\w\\p{P}]*")) {
                        writer.write(listWords[i]+" ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}