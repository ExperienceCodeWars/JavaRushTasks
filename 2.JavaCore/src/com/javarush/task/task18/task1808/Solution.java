package com.javarush.task.task18.task1808;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Watchable;
import java.util.Scanner;
/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args)throws IOException  {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        FileOutputStream fileOutputStream = new FileOutputStream(scanner.nextLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(scanner.nextLine());
        if(fileInputStream.available()>0){
        byte[] buffer = new byte[fileInputStream.available()];
        int count = fileInputStream.read(buffer);
        int temp = count/2;
        
        if(count%2!=0){
                fileOutputStream.write(buffer,0,temp+1);
                fileOutputStream1.write(buffer,temp+1,temp);
        }else{
        fileOutputStream.write(buffer,0,temp);
        fileOutputStream1.write(buffer,temp,temp);
        }
        }
        scanner.close();
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
