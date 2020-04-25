package com.javarush.task.task18.task1821;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
    Map<Character,Integer> mapa = new TreeMap<>();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]))) {
        byte [] buffer = new byte[inputStream.available()];
        char [] mass = new char[buffer.length];
        while(inputStream.available()>0){
            inputStream.read(buffer);
        }
        for (int i = 0; i < buffer.length; i++) {
                mass[i]=(char)buffer[i];
            }
            for (Character element: mass) {
                if(mapa.containsKey(element)){
                    int count = mapa.get(element)+1;
                    mapa.put(element,count);
                }else {
                 mapa.put(element,1);
                }
            }
            for (Map.Entry<Character, Integer> entry: mapa.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}