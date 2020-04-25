package com.javarush.task.task18.task1822;

import java.io.*;
/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
  try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readerFile = new BufferedReader(new FileReader(reader.readLine()))) {
        String line;
        while ((line=readerFile.readLine())!=null){
        if(line.startsWith(args[0] + " ")){
            System.out.println(line);
        }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}