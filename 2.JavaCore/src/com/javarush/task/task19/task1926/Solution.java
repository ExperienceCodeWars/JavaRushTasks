package com.javarush.task.task19.task1926;
import java.io.*;
/* 
Перевертыши
*/

public class Solution {
       public static void main(String[] args) {
        try (BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader= new BufferedReader(new FileReader(readerFileName.readLine()))) {
             String temp = null;
             while((temp=reader.readLine())!=null){
                 StringBuilder stringBuilder = new StringBuilder(temp);
                 System.out.println(stringBuilder.reverse().toString());
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}