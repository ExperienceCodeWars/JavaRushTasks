package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
Выделяем числа
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
                Pattern p = Pattern.compile("(\\b|^)\\d+?(\\b|$)");
                Matcher matcher = p.matcher(stringBuilder);
                while(matcher.find()){
                    fileWriter.write(stringBuilder.substring(matcher.start(),matcher.end())+" ");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
