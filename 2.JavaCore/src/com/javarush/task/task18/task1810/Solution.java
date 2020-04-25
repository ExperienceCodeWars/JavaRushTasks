package com.javarush.task.task18.task1810;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream;
        byte[]temp=new byte[1000];
        boolean x = true;
        byte [] stream;
        List<FileInputStream> list= new ArrayList<>();
        while(x){
             fileInputStream = new FileInputStream(scanner.nextLine());
             list.add(fileInputStream);
             stream = new byte[fileInputStream.available()];
            if(stream.length<temp.length){
                x=false;
                for (FileInputStream element : list) {
                    element.close();
                }
                 throw new DownloadException();
            }
           
        }
    }

    public static class DownloadException extends Exception {

    }
}
