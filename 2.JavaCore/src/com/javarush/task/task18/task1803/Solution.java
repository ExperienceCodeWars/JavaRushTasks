package com.javarush.task.task18.task1803;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    FileInputStream fs = new FileInputStream(s);
    byte[]bytes =  new byte[256];

        while(fs.available()>0){
            ++bytes[fs.read()];
        }

        for (int i = 0; i<bytes.length;i++){
            if(bytes[i]>2)
            System.out.print(i+" ");
        }
        
        fs.close();
    }
}
