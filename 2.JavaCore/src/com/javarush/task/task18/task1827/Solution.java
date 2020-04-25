package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.*;
/* 
Прайсы
*/

public class Solution {
   public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
        FileWriter outputStream = new FileWriter(fileName, true);

        String stringOfFile;
        int idFromFile = 0;
        ArrayList<Integer> listOfID = new ArrayList<>();

        if (args.length > 0 && args[0].equals("-c")) {

            while ((stringOfFile = inputStream.readLine()) != null) {
                String str = stringOfFile.substring(0, 8).trim();
                idFromFile = Integer.parseInt(str);
                listOfID.add(idFromFile);
            }

            int maxNumID = Collections.max(listOfID);
            String productName = args[1];
            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);
            outputStream.write(String.format("%n%-8d%-30.30s%-8.2f%-4d", ++maxNumID, productName, price, quantity));

        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}