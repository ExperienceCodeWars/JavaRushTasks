package com.javarush.task.task19.task1911;

import java.io.*;
/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    //запоминаем настоящий PrintStream в специальную переменную
    PrintStream consoleStream = System.out;
    //Создаем динамический массив
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //создаем адаптер к классу PrintStream
    PrintStream stream = new PrintStream(outputStream);
    
    System.setOut(stream);
    
    testString.printSomething();
    
    String result = outputStream.toString();
    
    System.setOut(consoleStream);
    
    System.out.println(result.toUpperCase());
    
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
