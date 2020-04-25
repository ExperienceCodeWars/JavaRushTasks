package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        int position = fileName.lastIndexOf(".");
        String ext = position >= 0 ? fileName.substring(position) : "";
        try{
            switch (ext){
                case ".xml":
                    FileInputStream fis = new FileInputStream(fileName);
                    properties.loadFromXML(fis);
                    fis.close();
                    break;
                case ".txt":
                    FileReader fr = new FileReader(fileName);
                    properties.load(fr);
                    fr.close();
                    break;
                default:
                    FileInputStream fileInputStream = new FileInputStream(fileName);
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    break;
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            return properties;
        }
        return properties;
    }
}
