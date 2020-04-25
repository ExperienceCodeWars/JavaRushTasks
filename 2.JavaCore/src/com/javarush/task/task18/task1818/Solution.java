package com.javarush.task.task18.task1818;
import java.io.*;
/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(reader.readLine(),true));
            InputStream inputStream = new BufferedInputStream(new FileInputStream(reader.readLine()));
            InputStream inputStream2 = new BufferedInputStream(new FileInputStream(reader.readLine()))){
            while (inputStream.available()>0){
                outputStream.write(inputStream.read());
            }
            while (inputStream2.available()>0){
                outputStream.write(inputStream2.read());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
