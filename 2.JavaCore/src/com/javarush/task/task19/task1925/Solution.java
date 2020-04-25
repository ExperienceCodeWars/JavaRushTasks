package com.javarush.task.task19.task1925;
import java.io.*;
import java.util.*;
/* 
Длинные слова
*/

public class Solution {
     public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer= new BufferedWriter(new FileWriter(args[1]))) {
            String temp = null;
            List<String>result = new ArrayList<>();
            while((temp=reader.readLine())!=null){
                String [] list = temp.split(" ");
                for(int i = 0; i<list.length; i++){
                    if(list[i].length()>6){
                        result.add(list[i]);
                    }
                }
            }
            for (int i = 0;i<result.size();i++){
                if (i==result.size()-1){
                    writer.write(result.get(i));
                    break;
                }
                writer.write(result.get(i)+",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}