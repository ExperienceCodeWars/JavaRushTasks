package com.javarush.task.task18.task1801;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws IOException {
   Scanner sc = new Scanner(System.in);
   String s = sc.nextLine();
   FileInputStream fs = new FileInputStream(s);
        int x=0;
        int y=0;
        while(fs.available()>0){
            if(x<(y=fs.read()))
            x=y;
        }
       
        sc.close();
        fs.close();
         System.out.println((byte)x);
    }
}

