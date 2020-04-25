package com.javarush.task.task18.task1809;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args)throws IOException {
           Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        FileOutputStream fileOutputStream= new FileOutputStream(scanner.nextLine());
        if(fileInputStream.available()>0){
            byte [] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            byte[]bufferRevers = revers(buffer);
            fileOutputStream.write(bufferRevers);
        }
        scanner.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static byte[] revers(byte[] buffer){
        byte [] tempBuffer = new byte[buffer.length];
        int x = 0;
        for (int i = buffer.length-1; i >=0 ; i--) {
            tempBuffer[x]=buffer[i];
            x++;
        }
        return tempBuffer;
    }
}
