package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
   static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)))) 
        {
            String re;
            while ((re = reader.readLine()) != null) {
                lines.add(re);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
