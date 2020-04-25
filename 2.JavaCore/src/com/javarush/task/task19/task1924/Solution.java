package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;
/* 
Замена чисел
*/

public class Solution {
      public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
       public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()))) {
            String temp = null;
            StringBuilder result = new StringBuilder();
            while ((temp = reader1.readLine()) != null) {
                String[] list = temp.split(" ");
                for (int i = 0; i < list.length; i++) {
                    for (Map.Entry<Integer, String> pair : map.entrySet()) {
                        if (list[i].equals(pair.getKey() + "")) {
                            list[i] = pair.getValue();
                        }
                    }
                }
                for (int i = 0; i < list.length; i++) {
                    result.append(list[i]+" ");
                    if (list.length - 1 == i) {
                        result.append("\n");
                    }
                }
            }
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




