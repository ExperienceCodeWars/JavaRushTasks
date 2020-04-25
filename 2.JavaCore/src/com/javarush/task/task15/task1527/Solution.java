package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String s = reader.readLine();
            String [] strings = s.split("\\?");

            String [] strings1=strings[1].split("&");

            String [] strings2;
            for (String element:strings1){
              strings2=element.split("=.+");
                System.out.print(strings2[0]+" ");
            }
            System.out.println();
            String []strings3;
            for (int i = 0; i <strings1.length ; i++) {
                if(strings1[i].contains("obj")){
                    strings3=strings1[i].split("=");
                    try{
                        alert(Double.parseDouble(strings3[1]));
                    }catch (NumberFormatException e){
                         alert(strings3[1]);
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}

