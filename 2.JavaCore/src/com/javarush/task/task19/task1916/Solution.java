package com.javarush.task.task19.task1916;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;
/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        //reader for reading file name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //readers for reading files
        BufferedReader readerFile1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(reader.readLine()));

        //close reader
        reader.close();

        //2 String variables
        String oldFile;
        String editFile;

        //2 ArrayLists
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        //loops for file reading
        while ((oldFile = readerFile1.readLine()) != null) {
            list1.add(oldFile);
        }
        while ((editFile = readerFile2.readLine()) != null) {
            list2.add(editFile);
        }
        //close 1 and 2 file reader
        readerFile1.close();
        readerFile2.close();
        while (list1.size() > 1 || list2.size() >1){
            if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME,list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            }else if (list1.get(1).equals(list2.get(0))){
                lines.add(new LineItem(Type.REMOVED,list1.get(0)));
                list1.remove(0);
            }else if (list1.get(0).equals(list2.get(1))){
                lines.add(new LineItem(Type.ADDED,list2.get(0)));
                list2.remove(0);
            }
        }
        if (list1.size() == 0){ lines.add(new LineItem(Type.ADDED,list2.get(0)));}
        if (list2.size() == 0){ lines.add(new LineItem(Type.REMOVED,list1.get(0)));}
    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}