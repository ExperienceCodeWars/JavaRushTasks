package com.javarush.task.task18.task1807;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        int count = 0;
        while (inputStream.available() > 0) {
            if (inputStream.read() == ',') count++;
        }
        System.out.println(count);
        scanner.close();
        inputStream.close();
    }
}
