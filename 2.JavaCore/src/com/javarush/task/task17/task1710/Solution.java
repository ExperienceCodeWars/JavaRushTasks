package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
         SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person p;
        switch (args[0]) {
            case "-c": //-c Миронов м 15/04/1990
                
                  Date date = dateFormat.parse(args[3]);
                if (args[2].equals("м")) {
                p=Person.createMale(args[1], date);
                allPeople.add(p);
                System.out.println(allPeople.indexOf(p));
                    
                }
                else {
                    p=Person.createFemale(args[1], date);
                    allPeople.add(p);
                        
                System.out.println(allPeople.indexOf(p));
                }

                break;

            case "-u":  //-u id name sex bd
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);

                Date date1 = dateFormat.parse(args[4]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(date1);

                if (args[3].equals("м")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                break;

            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                break;

            case "-i":
                String male = "м";
                String female = "ж";
                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                        + male + " "
                        + dateFormat1.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                else System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                        + female + " "
                        + dateFormat1.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                break;

        }
    }
}
