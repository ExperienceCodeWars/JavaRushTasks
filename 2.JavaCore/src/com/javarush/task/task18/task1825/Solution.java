package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        String fileName = reader.readLine();
        String[] resultFile = fileName.split(".part");
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile[0]);
        byte [] buff =null;
        TreeMap<Integer,byte[]> map = new TreeMap<>();
        while (!fileName.equals("end")) {
            fileInputStream=new FileInputStream(fileName);
            buff=new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            String[] numberPart = fileName.split("part");
            map.put(Integer.parseInt(numberPart[numberPart.length-1]),buff);
            fileName=reader.readLine();
            if (fileInputStream!=null) {
                fileInputStream.close();
            }
        }
        for (Map.Entry<Integer,byte[]> entry: map.entrySet()) {
            fileOutputStream.write(entry.getValue());
        }
        reader.close();
        fileOutputStream.close();
    }
}
