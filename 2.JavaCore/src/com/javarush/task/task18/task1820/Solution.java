package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args)throws IOException  {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        byte[] array = new byte[0];
        byte[] mass = new byte[0];

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file1));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2))) {

            array = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                inputStream.read(array);
            }
            List<String> massString = new ArrayList<>(Arrays.asList(new String(array).split(" ")));
            StringBuilder result = new StringBuilder();
            for (String s : massString) result.append((int)Math.round(Double.parseDouble(s))).append(" ");

            mass = result.toString().getBytes();
            outputStream.write(mass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}