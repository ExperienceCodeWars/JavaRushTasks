package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {
    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        @Override
        public String toString() {
            return greeting + "I am " + firstName + " " + lastName + " I from " +
                    country + ". I am a " + sex;
        }

        private Object readResolve() {
            return new Person(this.firstName, this.lastName,
                    this.country, this.sex);
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        try {
            Person person = new Person("Stanislav", "KV", "USA", Sex.MALE);
            System.out.println(person);
            FileOutputStream fileOutputStream = new FileOutputStream("Person.data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            fileOutputStream.close();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("Person.data");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            Person person1 = (Person) object;
            System.out.println(person1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

