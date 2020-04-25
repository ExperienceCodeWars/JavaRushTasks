package com.javarush.task.task19.task1910;

import java.io.*;
/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileNameSecond = reader.readLine();
            String fileNameLast = reader.readLine();
            reader.close();
            try(BufferedReader fileReader =new BufferedReader(new FileReader(fileNameSecond));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileNameLast))){
                StringBuilder stringBuilder = new StringBuilder();
                while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
                }
                String result = stringBuilder.toString().replaceAll("\\p{Punct}","");
                char[]mass=result.toCharArray();

                    fileWriter.write(mass);

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
