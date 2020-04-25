package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;
/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String fileName = reader.readLine();
      reader.close();
      FileInputStream fis = new FileInputStream(fileName);
      load(fis);
      fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
    Properties prop = new Properties();
    prop.putAll(properties);
    prop.store(outputStream,"My Properties");
    }

    public void load(InputStream inputStream) throws Exception {
    Properties prop = new Properties();
    prop.load(inputStream);
    properties.putAll((Map)prop);
    }

    public static void main(String[] args) {

    }
}
