package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.*;
import java.text.*;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
    private Scanner fileScanner;
    public PersonScannerAdapter(Scanner fileScanner){
        this.fileScanner=fileScanner;
    }
   
    public Person read() throws IOException{
     String[] pers = fileScanner.nextLine().split(" ", 4);
     SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
                 String d = pers[3];
                 String first = pers[1];
                 String middleName = pers[2];
                 String lastName = pers [0];
                 Date date = null;
                 try{date = dateFormat.parse(d);
                 }catch(ParseException e){
                     
                 }
    return new Person(first,middleName,lastName,date);
    }

    public void close() throws IOException{
    fileScanner.close();
    }
    }
}
