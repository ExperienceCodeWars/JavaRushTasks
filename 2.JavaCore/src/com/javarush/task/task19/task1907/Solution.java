package com.javarush.task.task19.task1907;
import java.io.*;
/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        try(FileReader fileReader = new FileReader(fileName)){
            StringBuilder stringBuilder = new StringBuilder();
            while(fileReader.ready()){
            stringBuilder.append((char)(fileReader.read()));

            }
            int count=0;
            String[] arr = stringBuilder.toString().replaceAll("\\W", " ").split(" ");
            for (String s : arr)
                if (s.trim().equals("world")) count++;
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

