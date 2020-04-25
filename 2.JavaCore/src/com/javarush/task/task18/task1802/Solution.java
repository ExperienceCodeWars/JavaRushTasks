package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    FileInputStream fs = new FileInputStream(s);
        byte min=127;
       
        while(fs.available()>0){
            int temp = fs.read();        
            if(temp <= min){
            min=(byte)temp;
        }
        }
       
        sc.close();
        fs.close();
         System.out.println(min);
    }
}
