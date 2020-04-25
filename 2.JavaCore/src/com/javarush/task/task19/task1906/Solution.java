package com.javarush.task.task19.task1906;

import java.io.*;
/* 
Четные символы
*/

public class Solution {
       public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameSecond = reader.readLine();
        String fileNameLast = reader.readLine();
        reader.close();
        try(FileReader fileReader = new FileReader(fileNameSecond);
            FileWriter fileWriter = new FileWriter(fileNameLast)){
            int count = 0;
            while(fileReader.ready()){
                int data = fileReader.read();
                count++;
                if(count%2==0)fileWriter.write(data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
