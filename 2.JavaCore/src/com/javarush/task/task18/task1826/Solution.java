package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.*;
/* 
Шифровка
*/

public class Solution {
public static void main(String[] args) {
        switch (args[0]) {
            case "-e":
                try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]));
                     InputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]))) {
                    if (args.length != 0) {
                        while (inputStream.available() > 0) {
                            outputStream.write(inputStream.read() + 1);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-d":
                try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]));
                     InputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]))) {
                    if (args.length != 0) {
                        while (inputStream.available() > 0) {
                            outputStream.write(inputStream.read() - 1);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}