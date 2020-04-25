package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;
/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)throws ParseException {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person p;
        switch (args[0]) {
            case "-c": //-c Миронов м 15/04/1990
                synchronized(allPeople){
                for(int i = 1; i<args.length;i=i+3){
                    Date date = dateFormat.parse(args[i+2]);
                    String name = args[i];
                    if(args[i+1].equals("м")){
                        p=Person.createMale(name,date);
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }else{
                        p=Person.createFemale(name,date);
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }
                }
                }

                break;

            case "-u":  //-u id name sex bd
            synchronized(allPeople){
             for(int i = 1; i<args.length;i=i+4){
                allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);

                Date date1 = dateFormat.parse(args[i+3]);
                allPeople.get(Integer.parseInt(args[i])).setBirthDate(date1);

                if (args[i+2].equals("м")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                else allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
             }
            }
                break;
                

            case "-d":
                synchronized(allPeople){
                
                for(int i = 1;i<args.length;i++){   
                
                allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
                }
                break;
                }

            case "-i":
                synchronized(allPeople){
                for(int i = 1;i<args.length;i++){    
            
                String male = "м";
                String female = "ж";
                if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE))
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                        + male + " "
                        + dateFormat1.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                else System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " "
                        + female + " "
                        + dateFormat1.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                
                    }
                }
                break;

    }
}
}
