package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     while(true){
         String key = reader.readLine();
           if (key.equals("exit"))
               break;
           else {
               try {
                   if (key.contains("."))
                       print(Double.parseDouble(key));
                        else if (Integer.parseInt(key) <= 0 || Integer.parseInt(key) >= 128)
                       print(Integer.parseInt(key));
                   else if (Short.parseShort(key) > 0 && Short.parseShort(key) < 128)
                       print(Short.parseShort(key));
                 

               } catch (Exception e) {
                   print(key);
               }
           }
       }
    }
       public static boolean isShort(String s){
        try{
            int n = Integer.parseInt(s);
            if (n > 0 && n < 128){
                return true;
            }
        }catch(Exception e) {
                return false;
            }
            return false;
    }
    public static boolean isInteger (String s){
        try{
            int n = Integer.parseInt(s);
            if(n <= 0 || n >= 128){
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
