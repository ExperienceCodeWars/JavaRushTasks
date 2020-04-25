package com.javarush.task.task18.task1817;

import java.io.*;
/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
 double countSpace = 0;
        double countSymbol = 0;
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]))){
            while(inputStream.available()>0){
                if(inputStream.read()==32) {
                    countSpace++;
                    countSymbol++;
                } else countSymbol++;
            }
            System.out.printf("%.2f",(countSpace*100/countSymbol));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}