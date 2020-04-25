package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.*;
/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
    String temp;
    String fileName = args[0];
    Map<String, Double> mapa = new TreeMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String[] mass = new String[2];
        while ((temp = reader.readLine()) != null) {
        mass = temp.split(" ");
        if (mapa.containsKey(mass[0])) {
            double count = mapa.get(mass[0]);
            mapa.put(mass[0], count + Double.parseDouble(mass[1]));
        } else {
            mapa.put(mass[0], Double.parseDouble(mass[1]));
                }
            }
        for (Map.Entry<String, Double> entry: mapa.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}