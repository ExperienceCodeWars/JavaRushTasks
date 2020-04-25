package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;
/* 
Нити и байты
*/

public class Solution {
      public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String nameFile;
            while (!(nameFile = reader.readLine()).equals("exit")) {
                ReadThread thread = new ReadThread(nameFile);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        public void run() {
            try (InputStream is = new BufferedInputStream(new FileInputStream(fileName))) {
                int b;
                List<Integer> list = new ArrayList<>();
                Map<Integer, Integer> map = new TreeMap<>();

                while (is.available() > 0) {
                    list.add(is.read());
                }

                for (Integer element : list) {
                    if (map.containsKey(element)) {
                        int count = map.get(element);
                        map.put(element, count + 1);
                    } else map.put(element, 1);
                }
                int max = 0;
                int resultCoin = 0;
                for (Map.Entry<Integer, Integer> item : map.entrySet()) {
                    if (item.getValue() > max) {
                        resultCoin = item.getKey();
                        max = item.getValue();
                    }
                    resultMap.put(fileName,resultCoin);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            // implement file reading here - реализуйте чтение из файла тут
        }
    }
}