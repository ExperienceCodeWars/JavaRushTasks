package com.javarush.task.task17.task1721;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2  = scanner.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName1))){
         String x;
         while ((x=reader.readLine())!=null){
             allLines.add(x);
         }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e){
            e.printStackTrace();
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName2))){
            String x;
            while ((x=reader.readLine())!=null){
                forRemoveLines.add(x);
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e){
            e.printStackTrace();
        }
         Solution sl = new Solution();
        try {
            sl.joinData();
            System.out.println(allLines);
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }
    
    

    public void joinData() throws CorruptedDataException {
  if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
 else {
    allLines.clear();
    throw new CorruptedDataException();
}
    }
}
