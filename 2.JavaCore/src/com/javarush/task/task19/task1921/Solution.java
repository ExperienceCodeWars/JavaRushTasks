package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/* 
Хуан Хуанович
*/

public class Solution {
     public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String fileName = args[0];
        String temp;
        String[] info = new String[2];
        Date date;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((temp = reader.readLine()) != null) {
                info = temp.split("(?<=\\D)\\s(?=[0-9\\s])");
                PEOPLE.add(new Person(info[0], new SimpleDateFormat("dd MM yyyy").parse(info[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}