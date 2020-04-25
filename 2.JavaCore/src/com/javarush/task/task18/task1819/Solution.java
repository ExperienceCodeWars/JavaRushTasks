package com.javarush.task.task18.task1819;

import java.io.*;
/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        byte[] array = new byte[0];
        byte[] array1 = new byte[0];

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file1));
             InputStream inputStream1 = new BufferedInputStream(new FileInputStream(file2))) {
            array = new byte[inputStream.available()];
            if (inputStream.available() > 0) {
                int temp = inputStream.read(array);
            }
            array1 = new byte[inputStream1.available()];
            if (inputStream1.available() > 0) {
                int temp1 = inputStream1.read(array1);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1))) {

            outputStream.write(array1);

            outputStream.write(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}