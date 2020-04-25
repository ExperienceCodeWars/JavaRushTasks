package com.javarush.task.task32.task3210;


/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
    String fileName = args[0];
    int number = Integer.parseInt(args[1]);
    String text = args[2];

    try(RandomAccessFile raf = new RandomAccessFile(fileName,"rw")){
    byte[]mass = new byte[text.length()];
    raf.seek(number);
    raf.read(mass,0,mass.length);
    String lineFromFile = new String(mass);
    String storeToFile = lineFromFile.equals(text) ? "true":"false";
    raf.seek(raf.length());
    raf.write(storeToFile.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
