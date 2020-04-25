package com.javarush.task.task19.task1922;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String temp;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((temp = reader.readLine()) != null) {
                int count = 0;
                String[] list = new String[100];
                list = temp.split("[\\p{Space}\\p{Punct}]");
                for (int i = 0; i < list.length; i++) {
                    String element = list[i].toLowerCase();
                    for (int k = 0; k < words.size(); k++) {
                        if (element.trim().equals(words.get(k).toLowerCase())) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    System.out.println(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


