package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        String later = "abcdefghijklmnopqrstuvwxyz";
        String digit = "1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <4; i++) {
            sb.append(later.charAt((int) (Math.random() * 26)));
        }
        for (int i = 0; i <2; i++) {
            sb.append(digit.charAt((int) (Math.random() * 10)));
        }
        for (int i = 0; i < 2; i++) {
            sb.append(later.toUpperCase().charAt((int) (Math.random() * 26)));
        }
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            baos.write(sb.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos;
    }
}