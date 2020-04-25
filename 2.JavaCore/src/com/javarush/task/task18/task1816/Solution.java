package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 0;
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]))){
            while(inputStream.available()>0){
                list.add(String.valueOf((char)inputStream.read()));
            }
            for (String element : list) {
                if(element.matches("[a-z]") |element.matches("[A-Z]"))count++;
            }
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }
}
